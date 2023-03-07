package Libreria.Servicios;

import Libreria.Entidades.Autor;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class servicioAutor {

    private final Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private final EntityManager em = Persistence.createEntityManagerFactory("libreriaPU").createEntityManager();

    public Autor crearAutor() throws Exception {
        try {
            Autor aut1 = new Autor();
            System.out.println("Ingrese el nombre del autor: ");
            aut1.setNombre(sc.next());
            aut1.setAlta(true);
            em.getTransaction().begin();
            em.persist(aut1);
            em.getTransaction().commit();
            System.out.println("\n");
            System.out.println("El Autor creado es: ");
            Autor autAux = (Autor) em.find(Autor.class, aut1.getId());
            System.out.println(autAux.toString());
            System.out.println("\n");
            return aut1;
        } catch (Exception e) {
            throw e;
        }
    }

    public Autor modificarAutor(Autor aut) throws Exception {
        try {
            System.out.println("Ingrese el nombre modificado: ");
            aut.setNombre(sc.next());
            em.getTransaction().begin();
            em.merge(aut);
            em.getTransaction().commit();
            System.out.println("\n");
            Autor autAux = em.find(Autor.class, aut.getId());
            System.out.println("Autor modificado: \n"
                    + autAux.toString() + "\n");
            return aut;
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarAutor() throws Exception {
        try {
            System.out.println("Inserte el id del Autor que va a Eliminar: ");
            long id = sc.nextLong();
            Autor aut = em.find(Autor.class, id);
            em.getTransaction().begin();
            em.remove(aut);
            em.getTransaction().commit();
            System.out.println("Actor elimindao correctamente \n");
        } catch (Exception e) {
            throw e;
        }
    }

    public void mostrarAutor() throws Exception {
        try {
            int op = 0;
            List<Autor> autores = null;
            do {
                System.out.println("-----Menu-----\n"
                        + "Ingrese una opcion\n"
                        + "1.Mostrar todo\n"
                        + "2.Mostrar ordenados por nombre A-Z\n"
                        + "3.Mostrar por nombre\n"
                        + "4.Mostrar por id\n"
                        + "5.Salir");
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        autores = em.createQuery("SELECT a FROM Autor a").getResultList();
                        mostrarLista(autores);
                        break;
                    case 2:
                        autores = em.createQuery("SELECT a FROM Autor a ORDER BY a.nombre ASC").getResultList();
                        mostrarLista(autores);
                        break;
                    case 3:
                        System.out.println("Ingrese el nombre del autor: ");
                        String nombre = sc.next();
                        autores = em.createQuery("SELECT a FROM Autor a "
                                + "WHERE a.nombre =:nombre").setParameter("nombre", nombre).getResultList();
                        mostrarLista(autores);
                        break;
                    case 4:
                        System.out.println("Ingrese el id del autor: ");
                        int id = sc.nextInt();
                        autores = em.createQuery("SELECT a FROM Autor a "
                                + "WHERE a.id =:id").setParameter("id", id).getResultList();
                        mostrarLista(autores);
                        break;
                    case 5:
                        System.out.println("------Saliendo------");
                        break;
                    default:
                        System.out.println("-----Numero Ingresado no Valido-----");
                }
            } while (op != 5);
        } catch (Exception e) {
            throw e;
        }
    }

    private void mostrarLista(List<Autor> autores) throws Exception {
        try {
            for (int i = 0; i < autores.size(); i++) {
                System.out.println(autores.get(i).toString() + "\n");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
