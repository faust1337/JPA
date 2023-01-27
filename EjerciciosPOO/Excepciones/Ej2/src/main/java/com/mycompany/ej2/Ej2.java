package com.mycompany.ej2;

public class Ej2 {

    public static void main(String[] args) {
        Clase c = new Clase();
        c.llenarNumeros();
        int contador = 0;
        try{
            for (int i = 0; i < 4; i++) {
                System.out.println(c.numeros[i]);
                contador++;
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("Has pasado el límite del arreglo (" + contador + ").");
        }
    }
    //Es mejor hacer un paquete Entidades, pero había que probar algo distinto :v
    public static class Clase {

        int[] numeros = new int[3];

        public void llenarNumeros() {
            for (int i = 0; i < 3; i++) {
                numeros[i] = i + 1;
            }
        }
    }
}