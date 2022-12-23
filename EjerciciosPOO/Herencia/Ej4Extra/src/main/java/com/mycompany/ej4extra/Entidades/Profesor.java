/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ej4extra.Entidades;
public class Profesor extends Empleado {
    private String departamento;

    public Profesor(String departamento, Integer incorporacion, Integer numDespacho, String nombre, boolean estadoCivil, Integer numID) {
        super(incorporacion, numDespacho, nombre, estadoCivil, numID);
        this.departamento = departamento;
    }
    public Profesor(){
        cargarProfesor();
    }
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public void cambiarDepartamento(){
        System.out.print("Nuevo departamento: ");
        departamento = leer.next();
    }
    
    public final void cargarProfesor(){
        super.cargarEmpleado();
        System.out.print("Departamento: ");
        departamento = leer.next();
    }
}
