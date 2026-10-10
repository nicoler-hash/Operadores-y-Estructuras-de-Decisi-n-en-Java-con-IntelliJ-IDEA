package org.example;

public class Reto2 {
    public static void main(String[] args) {


        String dictamen1 = evaluarRendimiento(85.5, 90, true);
        System.out.println("Estudiante 1 -> Dictamen: " + dictamen1);

        String dictamen2 = evaluarRendimiento(85.0, 75, true);
        System.out.println("Estudiante 2 -> Dictamen: " + dictamen2);

        String dictamen3 = evaluarRendimiento(55.0, 90, true);
        System.out.println("Estudiante 3 -> Dictamen: " + dictamen3);

        String dictamen4 = evaluarRendimiento(65.0, 50, false);
        System.out.println("Estudiante 4 -> Dictamen: " + dictamen4);
    }

    private static String evaluarRendimiento(double n, int a, boolean flag) {
        return "";
    }
}
