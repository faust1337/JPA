package com.mycompany.ej2extra;
import java.util.*;
import com.mycompany.ej2extra.Entidades.*;
public class Ej2Extra {

    public static void main(String[] args) {
        List<Edificio> edificios = new ArrayList();
        edificios.add(new Polideportivo("Paula montal", true, 40, 50, 25));
        edificios.add(new Polideportivo("Escuela normal", false, 40, 50, 15));
        edificios.add(new EdificioDeOficinas(3, 20, 30, 30, 15));
        edificios.add(new EdificioDeOficinas(4, 28, 50, 45, 26));
        int techado = 0, abiertos = 0;
        for (Edificio e : edificios) {
            if (e instanceof Polideportivo) {
                Polideportivo p = (Polideportivo) e;
                System.out.println("Polideportivo " + p.getNombre());
                if(p.isTechado()) techado++; 
                else abiertos++;
            }
            if (e instanceof EdificioDeOficinas) {
                EdificioDeOficinas eo = (EdificioDeOficinas) e;
                System.out.println("Edificio de oficinas");
                eo.cantPersonas();
            }
            System.out.println("Superficie: " + e.calcularSuperficie() + " metros cuadrados.");
            System.out.println("Volumen: " + e.calcularVolumen() + " metros cúbicos.\n");
        }
        System.out.println("Hay " + techado + " polideportivos techados y " + abiertos + " abiertos.");
    }
    //Se podría crear función para setear cada cosa mediante inputs, pero pa qué... xd
}
