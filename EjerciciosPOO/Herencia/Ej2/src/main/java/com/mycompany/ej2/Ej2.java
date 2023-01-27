package com.mycompany.ej2;

import com.mycompany.ej2.Entidades.*;

public class Ej2 {
    public static void main(String[] args) {
        System.out.println("CREANDO LAVADORA");
        Electrodomestico l = new Lavadora();
        l.precioFinal();
        System.out.println("CREANDO TELEVISOR");
        Electrodomestico t = new Televisor();
        t.precioFinal();
        System.out.println(l.toString());
        System.out.println(t.toString());
    }
}