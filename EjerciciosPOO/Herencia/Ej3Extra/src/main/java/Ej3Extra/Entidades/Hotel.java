package Ej3Extra.Entidades;

import java.util.Comparator;

public class Hotel extends Alojamiento{
    protected int cantHab, cantCamas, cantPisos;
    protected Integer precioHab;

    public Hotel(int cantHab, int cantCamas, int cantPisos, Integer precioHab, String nombre) {
        super(nombre);
        this.cantHab = cantHab;
        this.cantCamas = cantCamas;
        this.cantPisos = cantPisos;
        this.precioHab = precioHab;
    }
    

    public int getCantHab() {
        return cantHab;
    }

    public void setCantHab(int cantHab) {
        this.cantHab = cantHab;
    }

    public int getCantCamas() {
        return cantCamas;
    }

    public void setCantCamas(int cantCamas) {
        this.cantCamas = cantCamas;
    }

    public int getCantPisos() {
        return cantPisos;
    }

    public void setCantPisos(int cantPisos) {
        this.cantPisos = cantPisos;
    }

    public Integer getPrecioHab() {
        return precioHab;
    }

    public void setPrecioHab(Integer precioHab) {
        this.precioHab = precioHab;
    }
    
    public int precioHabitacion(){
        precioHab = 50+cantCamas;
        return precioHab;
    }
}
