package com.mycompany.ej4extra.Entidades;

public class PersonalServicio extends Empleado {
    private String seccion;
    public PersonalServicio(){
        cargarPersonalServicio();
    }
    public PersonalServicio(String seccion, Integer incorporacion, Integer numDespacho, String nombre, boolean estadoCivil, Integer numID) {
        super(incorporacion, numDespacho, nombre, estadoCivil, numID);
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    
    public void cambiarSeccion(){
        System.out.print("Nueva seccion: ");
        seccion = leer.next();
    }
    
    public final void cargarPersonalServicio(){
        super.cargarEmpleado();
        System.out.print("Seccion: ");
        seccion = leer.next();
    }
}

