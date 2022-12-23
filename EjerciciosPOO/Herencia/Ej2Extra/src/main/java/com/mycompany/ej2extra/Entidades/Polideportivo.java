package com.mycompany.ej2extra.Entidades;

public class Polideportivo extends Edificio {
    private String nombre;
    private boolean techado;

    public Polideportivo(String nombre, boolean techado, int ancho, int largo, int alto) {
        super(ancho, largo, alto);
        this.nombre = nombre;
        this.techado = techado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isTechado() {
        return techado;
    }

    public void setTechado(boolean techado) {
        this.techado = techado;
    }
    
    @Override
    public int calcularSuperficie() {
        return ancho*largo;
    }

    @Override
    public int calcularVolumen() {
        return ancho*largo*alto;
    }
    
}
