package servicios;

import entidades.Autor;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AutorServicio {
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private final EntityManager em = Persistence.createEntityManagerFactory("libreriaPU").createEntityManager();

    public Autor crearAutor(){
        try {
            Autor au = new Autor();
            System.out.print("Ingrese el nombre del autor: ");
            au.setNombre(leer.next());
            au.setAlta(true);
            em.getTransaction().begin();
            em.persist(au);
            em.getTransaction().commit();
            System.out.println("\nEl autor creado es: ");
            Autor aux = (Autor) em.find(Autor.class, au.getId());
            System.out.println(aux.toString());
            return au;
        } catch (Exception e) {
            throw e;
        }
    }
    
    
}
