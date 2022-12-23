package com.mycompany.ej4extra;

import java.util.*;
import com.mycompany.ej4extra.Entidades.*;
public class Ej4Extra {

    static Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        List<Persona> personas = new ArrayList();
        int opc;
        //Cargar la lista
        do {
            System.out.print("1: Cargar estudiante"
                    + "\n2: Cargar profesor"
                    + "\n3: Cargar personal de servicio"
                    + "\n4: Salir\nOpcion: ");
            opc = new Scanner(System.in).useDelimiter("\n").nextInt();
            switch(opc){
                case 1: personas.add(new Estudiante()); break;
                case 2: personas.add(new Profesor()); break;
                case 3: personas.add(new PersonalServicio()); break;
                case 4: System.out.println("Fin."); break;
                default: System.out.println("Opcion invalida.");
            }
        } while (opc!=4);
        
        //Mostrar el listado
        for (Persona persona : personas) {
            if (persona instanceof Estudiante) {
                Estudiante e = (Estudiante) persona;
                System.out.println("Nombre del estudiante: " + e.getNombre());
                e.cambiarCurso();
            }
            if(persona instanceof Profesor) {
                Profesor p = (Profesor) persona;
                System.out.println("Nombre del profesor: " + p.getNombre());
                p.cambiarDepartamento();
            }
            if(persona instanceof PersonalServicio) {
                PersonalServicio ps = (PersonalServicio) persona;
                System.out.println("Nombre del personal de servicio: " + ps.getNombre());
                ps.cambiarSeccion();
            }
        }
    }
}
