package Ej3Extra;
import java.util.*;
import Ej3Extra.Entidades.*;
public class Ej3Extra {
    static Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public static void main(String[] args) {
        List<Alojamiento> alojamientos = new ArrayList();
        alojamientos.add(new Hotel4E('b', "Mamma Mia", 85, 36, 72, 3, 0, "Hotel Americano"));
        alojamientos.add(new Hotel5E(2, 3, 4, 'a', "McDonalds", 150, 50, 125, 4, 0, "Hotel Sheraton"));
        alojamientos.add(new Camping(25, 3, true,"La calada", false, 2500));
        alojamientos.add(new Residencia(43, false, true,"Verde", true, 6000));
        
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Hotel) {
                Hotel object = (Hotel) alojamiento;
                object.setPrecioHab(object.precioHabitacion()); //De esta manera seteo el precio.
            }
        }
        menu(alojamientos);
        
    }
    public static void menu(List<Alojamiento> aloj){
        int opc;
        do {
            System.out.println("1: Consultar todos los alojamientos"
                    + "\n2: Listado de hoteles por precio de mayor a menor."
                    + "\n3: Listado de campings con restaurante."
                    + "\n4: Residencias con descuento para gremios."
                    + "\n5: Salir.");
            System.out.print("Opcion: "); opc = leer.nextInt();
            switch(opc){
                case 1: {
                    for (Alojamiento alojamiento : aloj) {
                        System.out.println(alojamiento.getNombre());
                    }
                }break;
                
                case 2:{
                    System.out.println("Listado ordenado del más barato al más caro.");
                    for(Hotel h : precioHoteles(aloj)){
                        System.out.println(h.getNombre() + ": $" + h.getPrecioHab());
                    }
                }break;
                
                case 3:{
                    int aux = 0;
                    for(Alojamiento alojamiento : aloj){
                        if (alojamiento instanceof Camping) {
                            Camping object = (Camping) alojamiento;
                            if(object.isRestaurante()) {
                                System.out.println("Camping " + object.getNombre());
                                aux++;
                            }
                        }
                    }
                    if (aux == 0) System.out.println("No hay campings con restaurante.");
                }break;
                
                case 4:{
                    int aux = 0;
                    for(Alojamiento alojamiento : aloj){
                        if (alojamiento instanceof Residencia) {
                            Residencia object = (Residencia) alojamiento;
                            if(object.isDescuentoGremios()) {
                                System.out.println("Residencia " + object.getNombre());
                                aux++;
                            }
                        }
                    }
                    if (aux == 0) System.out.println("No hay residencias con descuento al gremio.");
                }break;
                
                default: System.out.println("Opción inválida. Reingrese.");
            }
        } while (opc!=5);
    }
    public static List<Hotel> precioHoteles(List<Alojamiento> aloj){
        List<Hotel> hoteles = new ArrayList();
        for (Alojamiento alojamiento : aloj) {
            if (alojamiento instanceof Hotel) {
                Hotel hotel = (Hotel) alojamiento;
                hoteles.add(hotel);
            }
        }
        Collections.sort(hoteles, new Comparator<Hotel>() {
            @Override
            public int compare(Hotel h1, Hotel h2) {
                return h1.getPrecioHab().compareTo(h2.getPrecioHab());
            }
        });
        return hoteles;
    }
}
