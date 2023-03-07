package com.mycompany.libreria.servicios;

import com.mycompany.libreria.entidades.Autor;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AutorServicio {
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private EntityManager em = Persistence.createEntityManagerFactory("libreriaPU").createEntityManager();

    public Autor cargarAutor(){
        try {
            Autor au = new Autor();
            System.out.print("Nombre del autor: ");
            au.setNombre(leer.next());
            au.setAlta(true);
            em.getTransaction().begin();
            em.persist(au);
            em.getTransaction().commit();
            /*System.out.println("\nAutor ingresado: ");
            Autor aux = (Autor) em.find(Autor.class, au.getId());
            System.out.println(aux.toString());*/
            return au;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarAutor() throws Exception{
        em.getTransaction().begin();
        mostrarTabla();
        System.out.print("Ingrese el ID del autor a modificar: ");
        long id = leer.nextLong();
        try {
            Autor au = em.find(Autor.class, id);
            /*if(au.getId()==null){
                throw new Exception("Invalid ID");
            }*/
            int opc;
            do {
                System.out.println("MENU:\n1: Modificar nombre\n2: Dar de baja/alta\n3: Salir");
                opc = leer.nextInt();
                if (opc == 1) {
                    System.out.print("Ingrese el nuevo nombre: ");
                    au.setNombre(leer.next());
                } else if (opc == 2) {
                    au.setAlta(!au.isAlta());
                } else if (opc != 3) {
                    System.out.println("Opción inválida.");
                }
            } while (opc != 3);
            em.merge(au);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
        
        
        
    }
    
    
    
    
    
    
    
    
    
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
