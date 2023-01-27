package com.mycompany.ej1;

import com.mycompany.ej1.Entidades.Persona;
import com.mycompany.ej1.Servicios.Servicio;

public class Ej1 {

    public static void main(String[] args) {
        Servicio svc = new Servicio();
        Persona p = null;
        try{
            svc.esMayorDeEdad(p);
        }catch(NullPointerException e){
            System.out.println("La persona no ha sido instanciada");
        }/*finally{
            p = new Persona();
            if(p.getEdad()==0) System.out.println("La persona no ha sido instanciada correctamente o su edad es 0.");
        }*/
    }
}

//        Servicio svc = new Servicio();
//        //(String nombre, int edad, char sexo, double peso, double altura)
//        Persona p1 = new Persona("nombre1",18,'m',75.2,1.73);
//        Persona p2 = new Persona("Messi",35,'m',70,1.70);
//        Persona p3 = new Persona("nombre2",1,'o',12.3,1.93);
//        Persona p4 = new Persona("Maradona",100,'m',200,1.70);
//        Persona[] personas = new Persona[/*4*/]{p1,p2,p3,p4};
//        int personasLeidas = 0, flaquito = 0, joya = 0, gordo = 0, mayores = 0, menores = 0;
//        /*for (int i = 0; i < 4; i++) {
//            Persona p = svc.crearPersona();
//            personas[i] = p;
//        }*/
//        for (int i = 0; i < 4; i++) {
//            System.out.println((i+1) + "º persona.");
//            
//            if(svc.calcularIMC(personas[i]) == -1){
//                System.out.print("Está flaquito ");
//                flaquito++;
//            }else if (svc.calcularIMC(personas[i]) == 0){
//                System.out.print("Tiene el peso ideal ");
//                joya++;
//            }else {
//                System.out.print("Tiene sobrepeso ");
//                gordo++;
//            }
//            
//            if(svc.esMayorDeEdad(personas[i]) == true){
//                System.out.println(" y es mayor de edad.");
//                mayores++;
//            }else {
//                System.out.println(" y es menor de edad.");
//                menores++;
//            }
//            personasLeidas++;
//            System.out.println("-----------------------------------------");
//        }        
//        System.out.println("Hay un " + flaquito*100/personasLeidas + "% de gente flaquita.");
//        System.out.println("Hay un " + joya*100/personasLeidas + "% de gente en su peso ideal.");
//        System.out.println("Hay un " + gordo*100/personasLeidas + "% de gente con sobrepeso.");
//        System.out.println("El " + menores*100/personasLeidas + "% es menor de edad y el " + mayores*100/personasLeidas + "% es mayor de edad.");
//    