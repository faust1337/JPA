package Libreria.Servicios;

import Libreria.Entidades.Editorial;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;

public class servicioEditorial {

    private final Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private final EntityManager em = Persistence.createEntityManagerFactory("libreriaPU").createEntityManager();

    public Editorial crearEditorial() throws Exception {
        try {
            Editorial ed1 = new Editorial();
            System.out.println("Ingrese el nombre de la Editorial");
            ed1.setNombre(sc.next());
            ed1.setAlta(true);
            em.getTransaction().begin();
            em.persist(ed1);
            em.getTransaction().commit();
            System.out.println("La eitorial creada es: ");
            Editorial edAux = (Editorial) em.find(Editorial.class, ed1.getId());
            System.out.println(edAux.toString() + "\n");
            return ed1;
        } catch (Exception e) {
            throw e;
        }
    }

    public Editorial modificarEditorial(Editorial edi) throws Exception {
        try {
            System.out.println("Ingrese el nombre modificado: ");
            edi.setNombre(sc.next());
            em.getTransaction().begin();
            em.merge(edi);
            em.getTransaction().commit();
            Editorial ediAux = em.find(Editorial.class, edi.getId());
            System.out.println("\n"
                    + "Editorial modificada: \n"
                    + ediAux.toString() + "\n");
            return edi;
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarEditorial() throws Exception {
        try {
            System.out.println("Ingrese el id de la editorial a Eliminar: ");
            long id = sc.nextLong();
            Editorial edi = em.find(Editorial.class, id);
            em.getTransaction().begin();
            em.remove(edi);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void mostrarEditorial() throws Exception {
        try{
            int op = 0;
            List<Editorial> editoriales = null;
            do{
                System.out.println("-----Menu-----\n"
                        + "Ingrese una opcion\n"
                        + "1.Mostrar todo\n"
                        + "2.Mostrar ordenado por nombre A-Z\n"
                        + "3.Mostrar por nombre\n"
                        + "4.Mostrar por Id\n"
                        + "5.Salir");
                op = sc.nextInt();
                switch(op){
                    case 1:
                        editoriales = em.createQuery("SELECT e FROM Editorial e").getResultList();
                        mostrarLista(editoriales);
                        break;
                    case 2:
                        editoriales = em.createQuery("SELECT e FROM Editorial e ORDER BY e.nombre ASC").getResultList();
                        mostrarLista(editoriales);
                        break;
                    case 3:
                        System.out.println("Ingrese el nombre de la editorial: ");
                        String nombre = sc.next();
                        editoriales = em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre").setParameter("nombre", nombre).getResultList();
                        mostrarLista(editoriales);
                        break;
                    case 4:
                        System.out.println("Ingrese el Id el nombre de la editorial: ");
                        int id = sc.nextInt();
                        editoriales = em.createQuery("SELECT e FROM Editorial e WHERE e.id = :id").setParameter( "id", id).getResultList();
                        mostrarLista(editoriales);
                        break;
                    case 5:
                        System.out.println("-----Saliendo-----");
                        break;
                    default:
                        System.out.println("-----Numero ingresado no Valido-----");
                }
            }while(op != 5);
        }catch(Exception e){
            throw e;
        }
    }
    
    private void mostrarLista(List<Editorial> editoriales) throws Exception {
        try {
            for (int i = 0; i < editoriales.size(); i++) {
                System.out.println(editoriales.get(i).toString() + "\n");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
