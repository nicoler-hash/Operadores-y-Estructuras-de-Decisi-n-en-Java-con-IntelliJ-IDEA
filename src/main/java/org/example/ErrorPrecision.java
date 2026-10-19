package org.example;

public class ErrorPrecision {
    public static void main(String[] args) {
        int tareasCompletadas = 3;
        int tareasTotales = 4;

        // ERROR: 3 / 4 es division entera = 0.
        // CORRECCION: convertir a double antes de dividir.
        double porcentajeAvance = ((double) tareasCompletadas / tareasTotales) * 100;

        System.out.println("El porcentaje de avance es: " + porcentajeAvance + "%");
    }
}
