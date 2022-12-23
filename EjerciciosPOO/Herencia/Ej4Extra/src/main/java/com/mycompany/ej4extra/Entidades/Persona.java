package com.mycompany.ej4extra.Entidades;
import java.util.*;
public class Persona {
    protected final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    protected String nombre;
    protected boolean estadoCivil = false;
    protected Integer numID;
    public Persona(){
    }
    public Persona(String nombre, boolean estadoCivil, Integer numID) {
        this.nombre = nombre;
        this.estadoCivil = estadoCivil;
        this.numID = numID;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(boolean estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public Integer getNumID() {
        return numID;
    }
    public void setNumID(Integer numID) {
        this.numID = numID;
    }
    public void cambiarEstadoCivil(){
        estadoCivil = estadoCivil==false;
    }
    
    public final void cargarPersona(){
        System.out.print("Nombre: ");
        nombre=leer.next();
        System.out.print("Numero de ID: ");
        numID=leer.nextInt();
    }
}
