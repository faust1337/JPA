package Ej3Extra.Entidades;
public class Extrahotelero extends Alojamiento{
    protected boolean privado;
    protected int superficie;

    public Extrahotelero(String nombre, boolean privado, int superficie) {
        super(nombre);
        this.privado = privado;
        this.superficie = superficie;
    }

    public boolean isPrivado() {
        return privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }
}
