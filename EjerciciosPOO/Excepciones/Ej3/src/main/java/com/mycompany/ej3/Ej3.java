package com.mycompany.ej3;

import java.util.Scanner;

public class Ej3 {
    //Este ejercicio abarca el 4 también.
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.print("numero 1: ");
        String n1 = leer.next();
        System.out.print("numero 2: ");
        String n2 = leer.next();
        int num1 = 1, num2 = 1;
        try{
            num1 = Integer.parseInt(n1);
        }catch(NumberFormatException e){
            System.out.println("Has ingresado una letra en el número 1.");
        }
        
        try{
            num2 = Integer.parseInt(n2);
        }catch(NumberFormatException e){
            System.out.println("Has ingresado una letra en el número 2.");
        }
        
        try{
            float resultado = (float) num1/num2;//?¿??¿?¿??¿??
            System.out.println("Resultado: " + resultado);
        }catch(ArithmeticException e){
            System.out.println("División por cero, resultado indeterminado.");
        }
    }
}
