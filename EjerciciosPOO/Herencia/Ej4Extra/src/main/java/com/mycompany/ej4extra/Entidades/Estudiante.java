
package com.mycompany.ej4extra.Entidades;
public class Estudiante extends Persona{
    private String curso;
    public Estudiante(){
        cargarEstudiante();
    }
    public Estudiante(String curso, String nombre, boolean estadoCivil, Integer numID) {
        super(nombre, estadoCivil, numID);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    public void cambiarCurso(){
        System.out.print("Nombre del curso a matricular: ");
        curso = leer.next();
    }
    
    public final void cargarEstudiante(){
        super.cargarPersona();
        cambiarCurso();
    }
}
