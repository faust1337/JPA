package com.mycompany.ej4extra.Entidades;
public class Empleado extends Persona{
    protected Integer incorporacion, numDespacho;
    
    public Empleado(){
    }
    
    public Empleado(Integer incorporacion, Integer numDespacho, String nombre, boolean estadoCivil, Integer numID) {
        super(nombre, estadoCivil, numID);
        this.incorporacion = incorporacion;
        this.numDespacho = numDespacho;
    }

    public Integer getIncorporacion() {
        return incorporacion;
    }

    public void setIncorporacion(Integer incorporacion) {
        this.incorporacion = incorporacion;
    }

    public Integer getNumDespacho() {
        return numDespacho;
    }

    public void setNumDespacho(Integer numDespacho) {
        this.numDespacho = numDespacho;
    }
    
    public void reasignarDespacho(){
        System.out.print("Nro. despacho nuevo: ");
        numDespacho = leer.nextInt();
    }
    public final void cargarEmpleado(){
        super.cargarPersona();
        System.out.print("Año de ingreso a la institución: ");
        incorporacion = leer.nextInt();
        System.out.print("Numero de despacho: ");
        numDespacho = leer.nextInt();
    }
}
