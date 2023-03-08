package com.mycompany.libreria.servicios;

import com.mycompany.libreria.entidades.Autor;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AutorServicio {
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private final EntityManager em = Persistence.createEntityManagerFactory("libreriaPU").createEntityManager();

    public void cargarAutor(){
        try {
            Autor au = new Autor();
            System.out.print("Nombre del autor: ");
            au.setNombre(leer.next());
            au.setAlta(true);
            em.getTransaction().begin();
            em.persist(au);
            em.getTransaction().commit();
            System.out.println("\nAutor ingresado: ");
            Autor aux = (Autor) em.find(Autor.class, au.getId());
            System.out.println(aux.toString()+"\n");
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarAutor() throws Exception{
        em.getTransaction().begin();
        mostrarTabla();
        System.out.print("Ingrese el ID del autor a modificar: ");
        try {
            long id = leer.nextLong();
            Autor au = (Autor) em.find(Autor.class, id);
            if (au != null) {
                int opc;
                do {
                    System.out.println("MENU:\n1: Modificar nombre\n2: Dar de baja/alta\n3: Salir");
                    opc = leer.nextInt();
                    if (opc == 1) {
                        System.out.print("Ingrese el nuevo nombre: ");
                        au.setNombre(leer.next());
                    } else if (opc == 2) {
                        au.setAlta(!au.isAlta());
                        if(au.isAlta()) System.out.println("Dado de alta.");
                        else System.out.println("Dado de baja.");
                    } else if (opc != 3) {
                        System.out.println("Opción inválida.");
                    }
                } while (opc != 3);
                em.merge(au);
            } else {
                System.out.println("\nNo existe un autor con ese ID.");
            }
        } catch (Exception e) {
            System.out.println("Hubo un error en el ingreso del ID.");
        }finally {em.getTransaction().commit();}
    }
    
    /*public void buscarAutorPorNombre() throws Exception{
        System.out.println("Nombre del autor que desea buscar: ");
        String nombre = leer.next();
        Autor buscar = (Autor) em.createQuery("SELECT f FROM Autor f WHERE f.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();
        if(buscar==null) {throw new Exception("No existe el autor.");}
        else{
            System.out.println("Nombre: " + buscar.getNombre() + "\nID: " + buscar.getId());
        }
    }*/
    
    
    
    
    
    
    public void mostrarTabla(){
        try {
            List<Autor> tabla = em.createQuery("SELECT a FROM Autor a").getResultList();
            for(Autor a : tabla){
                System.out.println(a.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }
            
            
}
