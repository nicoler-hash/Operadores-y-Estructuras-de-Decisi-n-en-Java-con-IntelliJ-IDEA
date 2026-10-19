package org.example;

public class Reto3 {
    public static void main(String[] args) {
        double precioBase = 100.0;
        String[] tipos = {"VIP", "ESTUDIANTE", "ADULTO_MAYOR", "GENERAL"};

        for (String tipoEntrada : tipos) {
            double precioFinal;
            if (tipoEntrada.equals("VIP")) {
                precioFinal = precioBase * 1.10;
            } else if (tipoEntrada.equals("ESTUDIANTE")) {
                precioFinal = precioBase * 0.50;
            } else if (tipoEntrada.equals("ADULTO_MAYOR")) {
                precioFinal = precioBase * 0.60;
            } else {
                precioFinal = precioBase;
            }
            System.out.printf("Entrada %-13s -> Total a pagar: $%.2f%n", tipoEntrada, precioFinal);
        }
    }
}
