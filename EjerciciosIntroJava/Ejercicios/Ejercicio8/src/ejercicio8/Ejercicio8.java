package ejercicio8;

import java.util.Scanner;

public class Ejercicio8 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Frase: ");
        String frase = leer.nextLine();
        if (frase.length() == 8){
            System.out.println("Correcto");
        } else {
            System.out.println("Incorrecto. La frase tiene " + frase.length() + " caracteres.");
        }
    }
    
}
