package ej12.Entidades;

import java.util.Date;

public class Persona {
    private String nombre;
    private Date fechaNacimiento;

    public Persona() {
    }
    public Persona(String nombre, Date fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public int calcularEdad(){
        Date actual = new Date();
        return actual.getYear() - fechaNacimiento.getYear();
    }
    public void mostrarPersona(){
        System.out.println("Nombre: " + nombre + "\nNació el " + fechaNacimiento.getDate() + "/" + (fechaNacimiento.getMonth()+1) + "/" + fechaNacimiento.getYear());
    }
    public boolean menorQue(int edad){
        return calcularEdad() < edad;
    }
}
