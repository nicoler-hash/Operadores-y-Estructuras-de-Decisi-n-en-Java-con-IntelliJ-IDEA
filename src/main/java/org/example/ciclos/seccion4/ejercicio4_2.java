package org.example.ciclos.seccion4;

public class ejercicio4_2 {
    public static void main(String[] args) {
        System.out.println("Pares que no son múltiplos de 5 (1 a 50):");
        for (int i = 1; i <= 50; i++) {
            if (i % 2 != 0) {
                continue; // omite impares
            }
            if (i % 5 == 0) {
                continue; // omite múltiplos de 5
            }
            System.out.println(i);
        }
    }
}
