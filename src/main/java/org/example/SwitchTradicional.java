package org.example;

public class SwitchTradicional {
    public static void main(String[] args) {
        for (int dia = 0; dia <= 8; dia++) {
            String jornada;
            switch (dia) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    jornada = "Jornada Laboral";
                    break;
                case 6:
                    jornada = "Jornada Reducida (Sabado)";
                    break;
                case 7:
                    jornada = "Descanso (Domingo)";
                    break;
                default:
                    jornada = "Dia no valido";
                    break;
            }
            System.out.println("Dia " + dia + " -> " + jornada);
        }
    }
}
