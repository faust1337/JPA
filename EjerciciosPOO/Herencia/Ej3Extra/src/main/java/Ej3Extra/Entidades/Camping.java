package Ej3Extra.Entidades;
public class Camping extends Extrahotelero{
    private int cantMaxCarpas, cantBanos;
    private boolean restaurante;

    public Camping(int cantMaxCarpas, int cantBanos, boolean restaurante, String nombre, boolean privado, int superficie) {
        super(nombre, privado, superficie);
        this.cantMaxCarpas = cantMaxCarpas;
        this.cantBanos = cantBanos;
        this.restaurante = restaurante;
    }


    public int getCantMaxCarpas() {
        return cantMaxCarpas;
    }

    public void setCantMaxCarpas(int cantMaxCarpas) {
        this.cantMaxCarpas = cantMaxCarpas;
    }

    public int getCantBanos() {
        return cantBanos;
    }

    public void setCantBanos(int cantBanos) {
        this.cantBanos = cantBanos;
    }

    public boolean isRestaurante() {
        return restaurante;
    }

    public void setRestaurante(boolean restaurante) {
        this.restaurante = restaurante;
    }
    
}
