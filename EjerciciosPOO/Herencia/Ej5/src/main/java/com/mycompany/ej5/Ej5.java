package com.mycompany.ej5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej5 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean flag = true;
        int random = (int)(Math.random()*500 + 1), intentos = 0;
//        System.out.println(random);
        int num = 0;
        do{
            intentos++;
            try{
                System.out.print("Adivine el número secreto entre 1 y 500: ");
                num = leer.nextInt();
                if(num==random) {
                    System.out.println("¡Adivinaste el número secreto!\nIntentos: " + intentos);
                    flag = false;
                }
                else if(num>random) System.out.println("El número ingresado es mayor al secreto.");
                else System.out.println("El número ingresado es menor al secreto.");
            }catch(InputMismatchException e){
                System.out.println("Ingrese un número, no un caracter.");
                leer.next();
            }
        }while(flag);
    }
}
