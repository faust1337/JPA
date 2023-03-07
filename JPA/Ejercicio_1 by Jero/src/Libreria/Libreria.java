package Libreria;

import Libreria.Entidades.Autor;
import Libreria.Entidades.Editorial;
import Libreria.Servicios.servicioAutor;
import Libreria.Servicios.servicioEditorial;
import Libreria.Servicios.servicioLibro;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Libreria {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("libreriaPU").createEntityManager();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        servicioLibro servLib = new servicioLibro();
        servicioEditorial servEdi = new servicioEditorial();
        servicioAutor servAut = new servicioAutor();
        int op = 0;
        do {
            try {

                do {
                    System.out.println("-----Menu-----");
                    System.out.println("Ingrese una opcion");
                    System.out.println(""
                            + "1.Manipular Libros \n"
                            + "2.Manipular Autores\n"
                            + "3.Manipular Editoriales\n"
                            + "4.Salir");
                    op = sc.nextInt();
                    switch (op) {
                        case 1:
                            int opLib = 0;
                            do {
                                System.out.println("-----Menu-----\n"
                                        + "Ingrese una opcion\n"
                                        + "1.Crear uno o mas Libros\n"
                                        + "2.Modificar Libros\n"
                                        + "3.Eliminar libros\n"
                                        + "4.Mostrar Libros\n"
                                        + "5.Salir");
                                opLib = sc.nextInt();
                                switch (opLib) {
                                    case 1:
                                        servLib.crearLibro();
                                        break;
                                    case 2:
                                        servLib.modicarLibro();
                                        break;
                                    case 3:
                                        servLib.eliminarLibro();
                                        break;
                                    case 4:
                                        servLib.mostrarLibro();
                                        break;
                                    case 5:
                                        System.out.println("------Saliendo------");
                                        break;
                                    default:
                                        System.out.println("-----Numero ingresado no Valido-----");
                                }
                            } while (opLib != 5);
                            break;
                        case 2:
                            int opAut = 0;
                            do {
                                System.out.println("-----Menu-----\n"
                                        + "Inserte una opcion\n"
                                        + "1.Crear uno o mas Autores\n"
                                        + "2.Modificar Autor\n"
                                        + "3.Eliminar Autor\n"
                                        + "4.Mostrar Autores\n"
                                        + "5.Salir");
                                opAut = sc.nextInt();
                                switch (opAut) {
                                    case 1:
                                        Autor aux = servAut.crearAutor();
                                        break;
                                    case 2:
                                        System.out.println("Ingrese el id del Autor a modificar: ");
                                        Autor aut = em.find(Autor.class, sc.nextLong());
                                        aut = servAut.modificarAutor(aut);
                                        break;
                                    case 3:
                                        servAut.eliminarAutor();
                                        break;
                                    case 4:
                                        servAut.mostrarAutor();
                                    case 5:
                                        System.out.println("------Saliendo------");
                                        break;
                                    default:
                                        System.out.println("-----Numero ingresado no Valido-----");
                                }
                            } while (opAut != 5);
                            break;
                        case 3:
                            int opEdi = 0;
                            do {
                                System.out.println("-----Menu-----\n"
                                        + "Ingrese una opcion\n"
                                        + "1.Crear Editorial\n"
                                        + "2.Modificar Editorial\n"
                                        + "3.Eliminar Editorial\n"
                                        + "4.Mostrar Editorial\n"
                                        + "5.Salir");
                                opEdi = sc.nextInt();
                                switch (opEdi) {
                                    case 1:
                                        Editorial e = servEdi.crearEditorial();
                                        break;
                                    case 2:
                                        System.out.println("Ingrese el id de la editorial a modificar: ");
                                        Editorial edi = em.find(Editorial.class, sc.nextLong());
                                        edi = servEdi.modificarEditorial(edi);
                                        break;
                                    case 3:
                                        servEdi.eliminarEditorial();
                                        break;
                                    case 4:
                                        servEdi.mostrarEditorial();
                                        break;
                                    case 5:
                                        System.out.println("------Saliendo------");
                                        break;
                                    default:
                                        System.out.println("-----Numero ingresado no Valido-----");
                                }
                            } while (opEdi != 5);
                            break;
                        case 4:
                            System.out.println("------Saliendo------");
                            break;
                        default:
                            System.out.println("Numero ingresado no valido");
                    }
                } while (op != 4);
            
            } catch (Exception e) {
                for (int i = 0; i < 1200; i++) {
                    System.out.println("");
                }
                System.out.println("ERROR");
            }
        } while (op != 4);
    }

}
