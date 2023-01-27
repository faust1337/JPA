package com.mycompany.ej2extra;
import com.mycompany.ej2extra.Entidades.*;
import java.util.*;
public class Ej2Extra {
    static Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public static void main(String[] args) {
        Sala sala = new Sala();
        sala.setSala(cargarSala()); //Seteo la sala vacía.
        sala.setPelicula(cargarPelicula());//Seteo la película.
        System.out.print("Precio de entrada: $");
        sala.setPrecio(leer.nextInt());//Seteo el precio.
        cargarEspectadores(sala);//Agrego los espectadores hasta que corte o llegue a copar la sala.
        sala.ubicarEspectadores();//Método para ubicar aleatoriamente las personas.
        mostrarSala(sala.getSala());
    }
    
    public static Espectador cargarEspectador(){
        System.out.print("Nombre: ");
        String nombre = leer.next();
        System.out.print("Edad: ");
        Integer edad = leer.nextInt();
        System.out.print("Dinero disponible: $");
        Integer dinero = leer.nextInt();
        return new Espectador(nombre,edad,dinero);
    }
    public static Pelicula cargarPelicula(){
        Pelicula p = new Pelicula();
        System.out.print("Titulo: ");
        p.setTitulo(leer.next());
        System.out.print("Director: ");
        p.setDirector(leer.next());
        System.out.print("Edad mínima de entrada: ");
        p.setEdadMinima(leer.nextInt());
        System.out.print("Duración en minutos: ");
        p.setDuracion(leer.nextInt());
        return p;
    }    
    public static String [][] cargarSala(){
        String[][] sala = new String[8][6];
        for(int f = 0; f < 8; f++){
            for(int c = 0; c < 6; c++){
                switch(c){
                    case 0: sala[f][c] = ((f+1) + "A"); break;
                    case 1: sala[f][c] = ((f+1) + "B"); break;
                    case 2: sala[f][c] = ((f+1) + "C"); break;
                    case 3: sala[f][c] = ((f+1) + "D"); break;
                    case 4: sala[f][c] = ((f+1) + "E"); break;
                    case 5: sala[f][c] = ((f+1) + "F"); break;
                }
            }
        }
        return sala;
    }
    public static void mostrarSala(String [][] s){
        for(int f = 0; f < 8; f++){
            for(int c = 0; c < 6; c++){
                System.out.print("[" + s[f][c] + "] ");
            }
            System.out.println("");
        }
    }
    public static void cargarEspectadores(Sala sala){
        char opc;
        System.out.println("INICIANDO CARGA DE ESPECTADORES");
        for (int i = 0; i < 8*6; i++) {//Corta cuando llega al límite de la sala.
            Espectador e = cargarEspectador();
            if(e.getDinero()>=sala.getPrecio() && e.getEdad()>=sala.getPelicula().getEdadMinima()){
                sala.getEspectadores().add(e);
                System.out.println("Que disfrute su película. ¡SIGUIENTE!");
            }else{
                System.out.println("Lo siento, no le puedo dejar pasar. ¡SIGUIENTE!");
                i--;
            }
            do{
                System.out.println("¿Desea cargar otro espectador?");
                System.out.print("S/N: ");
                opc = leer.next().charAt(0);
                opc = Character.toLowerCase(opc);
                if (opc != 's' && opc != 'n') System.out.println("Opción inválida.");
                else if(opc=='n') i=8*6+1;
            }while(opc!='s' && opc!='n');
        }
    }
}