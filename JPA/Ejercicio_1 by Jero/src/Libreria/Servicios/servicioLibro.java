package Libreria.Servicios;

import Libreria.Entidades.Autor;
import Libreria.Entidades.Editorial;
import Libreria.Entidades.Libro;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;

public class servicioLibro {

    private final Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private final EntityManager em = Persistence.createEntityManagerFactory("libreriaPU").createEntityManager();
    private final servicioAutor servAutor = new servicioAutor();
    private final servicioEditorial servEd = new servicioEditorial();

    public void crearLibro() throws Exception {
        try {
            System.out.println("Ingrese cuantos libros desea crear: ");
            int cant = sc.nextInt();
            for (int i = 0; i < cant; i++) {
                System.out.println("-----Creando libro #" + (i + 1) + "-----");
                Libro lib = new Libro();
                System.out.println("Ingrese el titulo del libro: ");
                lib.setTitulo(sc.next());
                System.out.println("Ingrese el anio de creacion: ");
                lib.setAnio(sc.nextInt());
                System.out.println("Ingrese el numero de ejemplares: ");
                lib.setEjemplares(sc.nextInt());
                System.out.println("Se ha prestado lgun ejemplar de " + lib.getTitulo() + " (S/N): ");
                String op = sc.next();
                if (op.equalsIgnoreCase("s")) {
                    System.out.println("Ingrese cuantos libros se prestaron: ");
                    lib.setEjemplaresPrestados(sc.nextInt());
                    System.out.println("Ingrese cuantos libros quedan: ");
                    lib.setEjemplaresRestantes(sc.nextInt());
                } else {
                    lib.setEjemplaresPrestados(0);
                    lib.setEjemplaresRestantes(lib.getEjemplares());
                }
                Autor aut1 = servAutor.crearAutor();
                lib.setAutor(aut1);
                Editorial ed1 = servEd.crearEditorial();
                lib.setAlta(true);
                lib.setEditorial(ed1);
                em.getTransaction().begin();
                em.persist(lib);
                em.getTransaction().commit();
                System.out.println("El libro creado: ");
                Libro libAux = (Libro) em.find(Libro.class, lib.getId());
                System.out.println(libAux.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void modicarLibro() throws Exception {
        try {
            System.out.println("Ingrese el id del libro a modificar: ");
            Libro lib = em.find(Libro.class, sc.nextLong());
            int op = 0;
            do {
                System.out.println("-----Menu-----\n"
                        + "Ingrese una Opcion\n"
                        + "1.Modificar todo el libro\n"
                        + "2.Modificar el nombre y el año\n"
                        + "3.Modificar Existencias del libro\n"
                        + "4.Modificar el autor del libro\n"
                        + "5.Modificar la Editorial del libro\n"
                        + "6.Salir");
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        lib = modificarCompleto(lib);
                        em.getTransaction().begin();
                        em.merge(lib);
                        em.getTransaction().commit();
                        break;
                    case 2:
                        em.getTransaction().begin();
                        em.merge(modificarNombreAnio(lib));
                        em.getTransaction().commit();
                        break;
                    case 3:
                        em.getTransaction().begin();
                        em.merge(modificarExistencias(lib));
                        em.getTransaction().commit();
                        break;
                    case 4:
                        lib.setAutor(servAutor.modificarAutor(lib.getAutor()));
                        em.getTransaction().begin();
                        em.merge(lib);
                        em.getTransaction().commit();
                        break;
                    case 5:
                        lib.setEditorial(servEd.modificarEditorial(lib.getEditorial()));
                        em.getTransaction().begin();
                        em.merge(lib);
                        em.getTransaction().commit();
                        break;
                    default:
                        System.out.println("Numero Ingresado no valido");
                }
            } while (op != 6);
        } catch (Exception e) {
            throw e;
        }
    }

    private Libro modificarExistencias(Libro lib) throws Exception {
        try {
            System.out.println("Ingrese los ejemplares totales: ");
            lib.setEjemplares(sc.nextInt());
            System.out.println("Ingrese los ejemplares prestados: ");
            lib.setEjemplaresPrestados(sc.nextInt());
            System.out.println("ingrese los ejemplares restantes: ");
            lib.setEjemplaresRestantes(sc.nextInt());
            return lib;
        } catch (Exception e) {
            throw e;
        }
    }

    private Libro modificarNombreAnio(Libro lib) throws Exception {
        try {
            System.out.println("Ingrese el titulo modificado: ");
            lib.setTitulo(sc.next());
            System.out.println("Ingrese el año modificado: ");
            lib.setAnio(sc.nextInt());
            return lib;
        } catch (Exception e) {
            throw e;
        }
    }

    private Libro modificarCompleto(Libro lib) throws Exception {
        try {
            System.out.println("Ingrese el titulo modificado: ");
            lib.setTitulo(sc.next());
            System.out.println("Ingrese el año modificado: ");
            lib.setAnio(sc.nextInt());
            System.out.println("Ingrese el numero de ejemplares: ");
            lib.setEjemplares(sc.nextInt());
            System.out.println("Se han prestado libros de " + lib.getTitulo() + " (S/N): ");
            String op = sc.next();
            if (op.equalsIgnoreCase("s")) {
                System.out.println("Ingrese los ejemplares que se prestaron: ");
                lib.setEjemplaresPrestados(sc.nextInt());
                System.out.println("Ingrese los ejemplares que quedan: ");
                lib.setEjemplaresRestantes(sc.nextInt());
            } else {
                lib.setEjemplaresPrestados(0);
                lib.setEjemplaresRestantes(lib.getEjemplares());
            }
            Autor aut = em.find(Autor.class, lib.getAutor().getId());
            Editorial edi = em.find(Editorial.class, lib.getEditorial().getId());
            lib.setAutor(servAutor.modificarAutor(aut));
            lib.setEditorial(servEd.modificarEditorial(edi));
            lib.setAlta(true);
            return lib;
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarLibro() throws Exception {
        try {
            System.out.println("Ingrese el id del libro que desea Eliminar: ");
            Libro lib = em.find(Libro.class, sc.nextLong());
            em.getTransaction().begin();
            em.remove(lib);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }

    public void mostrarLibro() throws Exception {
        try {
            int op = 0;
            List<Libro> libros = null;
            do {
                System.out.println("-----Menu-----\n"
                        + "Ingresar una opcion\n"
                        + "1.Mostrar todo\n"
                        + "2.Mostrar ordenado por nombre A-Z\n"
                        + "3.Mostrar por nombre\n"
                        + "4.Mostrar por id\n"
                        + "5.Mostrar por Autor\n"
                        + "6.Mostrar por Editorial\n"
                        + "7.Salir");
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        libros = em.createQuery("SELECT l FROM Libro l").getResultList();
                        mostrarLista(libros);
                        break;
                    case 2:
                        libros = em.createQuery("SELECT l FROM Libro l ORDER By l.titulo ASC").getResultList();
                        mostrarLista(libros);
                        break;
                    case 3:
                        System.out.println("Ingrese el titulo del libro: ");
                        String titulo = sc.next();
                        libros = em.createQuery("SELECT l FROM Libro l WHERE l.titulo =:titulo").setParameter("titulo", titulo).getResultList();
                        mostrarLista(libros);
                        break;
                    case 4:
                        System.out.println("Ingrese el id:");
                        int id = sc.nextInt();
                        libros = em.createQuery("SELECT l FROM Libro l WHERE l.id =:id").setParameter("id", id).getResultList();
                        mostrarLista(libros);
                        break;
                    case 5:
                        System.out.println("Ingrese el nombre del Autor:");
                        String nombreA = sc.next();
                        libros = em.createQuery("SELECT l FROM Libro l WHERE l.autor = "
                                + "(SELECT a FROM Autor a WHERE a.nombre = :nombre)").setParameter("nombre", nombreA).getResultList();
                        mostrarLista(libros);
                        break;
                    case 6:
                        System.out.println("Ingrese el nombre de la Editorial:");
                        String nombreE = sc.next();
                        libros = em.createQuery("SELECT l FROM Libro l WHERE l.autor = "
                                + "(SELECT a FROM Autor a WHERE a.nombre =:nombre)").setParameter("nombre", nombreE).getResultList();
                        mostrarLista(libros);
                        break;
                    case 7:
                        System.out.println("-----Saliendo-----");
                        break;
                    default:
                        System.out.println("-----Numero ingreado no Valido-----");
                }
            } while (op != 7);
        } catch (Exception e) {
            throw e;
        }
    }

    private void mostrarLista(List<Libro> libros) throws Exception {
        try {
            for (int i = 0; i < libros.size(); i++) {
                System.out.println(libros.get(i).toString() + "\n");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
