package ejercicio15;

public class Ejercicio15 {

    public static void main(String[] args) {
        int[] vector = new int[100];
        for (int i = 0; i < 100; i++) {
            vector[i] = i;
        }
        for (int i = 99; i >= 0; i--) {
            System.out.print(vector[i] + " ");
        }
    }    
}