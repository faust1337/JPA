//Hotel 4E Cantidad de Habitaciones, Número de camas, Cantidad de Pisos, Gimnasio,
//Nombre del Restaurante, Capacidad del Restaurante, Precio de las Habitaciones.

package Ej3Extra.Entidades;
public class Hotel4E extends Hotel{
    protected char gimnasio;
    protected String nombreRestaurante;
    protected int capacidadRestaurante;

    public Hotel4E(char gimnasio, String nombreRestaurante, int capacidadRestaurante, int cantHab, int cantCamas, int cantPisos, Integer precioHab, String nombre) {
        super(cantHab, cantCamas, cantPisos, precioHab, nombre);
        this.gimnasio = gimnasio;
        this.nombreRestaurante = nombreRestaurante;
        this.capacidadRestaurante = capacidadRestaurante;
    }

    

    public char getGimnasio() {
        return gimnasio;
    }

    public void setGimnasio(char gimnasio) {
        this.gimnasio = gimnasio;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public int getCapacidadRestaurante() {
        return capacidadRestaurante;
    }

    public void setCapacidadRestaurante(int capacidadRestaurante) {
        this.capacidadRestaurante = capacidadRestaurante;
    }
    
    @Override
    public int precioHabitacion(){
        precioHab = super.precioHabitacion();
        if(capacidadRestaurante<30) precioHab+=10;
        else if(capacidadRestaurante>=30 && capacidadRestaurante<50) precioHab+=30;
        else precioHab+=50;
        if(gimnasio=='a' || gimnasio=='A') precioHab+=50;
        else precioHab+=30;
        return precioHab;
    }
    
}
