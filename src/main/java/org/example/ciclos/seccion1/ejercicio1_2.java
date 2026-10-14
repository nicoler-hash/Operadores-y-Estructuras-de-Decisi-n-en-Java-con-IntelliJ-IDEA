package org.example.ciclos.seccion1;

import java.util.Scanner;

public class ejercicio1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double LIMITE = 1_000_000;
        double acumulado = 0;
        boolean procesando = true;
        String causa = "";

        while (procesando) {
            System.out.print("Ingrese el monto de la transacción: $");
            double monto = sc.nextDouble();

            if (monto < 0) {
                causa = "Se ingresó un monto negativo (no válido).";
                procesando = false;
            } else {
                acumulado += monto;
                if (acumulado > LIMITE) {
                    causa = "Se superó el límite máximo permitido de $1'000.000.";
                    procesando = false;
                }
            }
        }

        System.out.println("\n--- Informe de caja ---");
        System.out.printf("Saldo final acumulado: $%,.2f%n", acumulado);
        System.out.println("Causa de finalización: " + causa);
        sc.close();
    }

}
