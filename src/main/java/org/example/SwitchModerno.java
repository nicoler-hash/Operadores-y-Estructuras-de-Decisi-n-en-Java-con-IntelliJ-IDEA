package org.example;

public class SwitchModerno {
    public static void main(String[] args) {
        for (int dia = 0; dia <= 8; dia++) {
            final String jornada = switch (dia) {
                case 1, 2, 3, 4, 5 -> "Jornada Laboral";
                case 6 -> "Jornada Reducida (Sabado)";
                case 7 -> "Descanso (Domingo)";
                default -> "Dia no valido";
            };
            System.out.println("Dia " + dia + " -> " + jornada);
        }
    }
}
