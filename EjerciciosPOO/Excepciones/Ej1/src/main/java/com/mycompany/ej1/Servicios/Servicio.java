package com.mycompany.ej1.Servicios;

import com.mycompany.ej1.Entidades.Persona;
import java.util.*;

public class Servicio {
    private Scanner leer = new Scanner(System.in);
    
    public Servicio(){}
    public Persona crearPersona(){
        Persona p = new Persona();
        System.out.print("Nombre: ");
        p.setNombre(leer.next());
        System.out.print("Edad: ");
        p.setEdad(leer.nextInt());
        System.out.print("Sexo M/F/O: ");
        char sexo = leer.next().charAt(0); sexo = Character.toUpperCase(sexo);
        while(sexo!='M' && sexo!= 'F' && sexo!='O'){
            System.out.print("Opción inválida. Reingrese.");
            System.out.print("Sexo M/F/O: ");
            sexo = leer.next().charAt(0); sexo = Character.toUpperCase(sexo);
        }
        System.out.print("Peso: ");
        p.setPeso(leer.nextDouble());
        System.out.print("Altura: ");
        p.setAltura(leer.nextDouble());
        return p;
    }
    public int calcularIMC(Persona p){
        double formula = p.getPeso()/Math.pow(p.getAltura(),2);
        if(formula < 20){
            return -1;
        }else if(formula>=20 && formula<=25){
            return 0;
        }else return 1;
    }
    public boolean esMayorDeEdad(Persona p){
        return (p.getEdad()>=18);
    }
}