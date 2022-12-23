package com.mycompany.ej2extra.Entidades;

import java.util.Scanner;

public class EdificioDeOficinas extends Edificio {
    private int cantOficinas, personasPorOficina; //Hay una oficina por piso, o sea, cantOficinas es, básicamente, los pisos.
    private int piso = cantOficinas;
    public EdificioDeOficinas(int cantOficinas, int personasPorOficina, int ancho, int largo, int alto) {
        super(ancho, largo, alto);
        this.cantOficinas = cantOficinas;
        this.personasPorOficina = personasPorOficina;
    }

    public int getCantOficinas() {
        return cantOficinas;
    }

    public void setCantOficinas(int cantOficinas) {
        this.cantOficinas = cantOficinas;
    }

    public int getPersonasPorOficina() {
        return personasPorOficina;
    }

    public void setPersonasPorOficina(int personasPorOficina) {
        this.personasPorOficina = personasPorOficina;
    }
    
    public void cantPersonas(){
        int cantidad = personasPorOficina*cantOficinas;
        System.out.println("Entran " + cantidad + " de personas. " + "(" +cantidad/cantOficinas+ " personas por piso.)");
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
