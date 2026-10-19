package com.educacion.ahorcado;

import java.util.Scanner;


public class ahorcado {


    static final int MAX_INTENTOS = 6;

    static final String[] PALABRAS = {
            "JAVA", "VARIABLE", "BUCLE", "CADENA", "COMPILADOR",
            "OBJETO", "CLASE", "METODO", "PAQUETE", "INTELLIJ"
    };


    static int partidasJugadas = 0;
    static int partidasGanadas = 0;
    static int partidasPerdidas = 0;
    static double mejorPuntaje = 0.0;

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;


        do {
            opcion = leerOpcionMenu();

            switch (opcion) {
                case 1:
                    jugar();
                    break;
                case 2:
                    mostrarEstadisticas();
                    break;
                case 3:
                    System.out.println("\n¡Gracias por jugar! Hasta pronto.");
                    break;
                default:

                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

        scanner.close();
    }


    static int leerOpcionMenu() {
        int opcion = 0;
        boolean valida = false;

        while (!valida) {
            System.out.println("\n==============================");
            System.out.println("   AHORCADO DE CONSOLA");
            System.out.println("==============================");
            System.out.println("1. Jugar");
            System.out.println("2. Ver Estadísticas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            String entrada = scanner.nextLine().trim();
            try {
                opcion = Integer.parseInt(entrada);
                if (opcion >= 1 && opcion <= 3) {
                    valida = true;
                } else {
                    System.out.println("⚠ Opción fuera de rango. Elija 1, 2 o 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Entrada no válida: ingrese solo números (1, 2 o 3).");
            }
        }
        return opcion;
    }


    static String leerNombreJugador() {
        String nombre = "";
        while (nombre.length() == 0) {
            System.out.print("\nIngrese su nombre: ");
            nombre = scanner.nextLine().trim().toUpperCase();
            if (nombre.length() == 0) {
                System.out.println("⚠ El nombre no puede estar vacío.");
            }
        }
        return nombre;
    }


    static void jugar() {
        String nombreJugador = leerNombreJugador();


        int intentosRestantes = MAX_INTENTOS;
        double puntaje = 100.0;
        boolean juegoGanado = false;
        boolean rendido = false;
        boolean pistaMostrada = false;
        char ultimaLetra = ' ';
        int aciertos = 0;
        int totalIntentos = 0;
        int turnos = 0;

        String palabraSecreta = PALABRAS[(int) (Math.random() * PALABRAS.length)];


        StringBuilder mascara = new StringBuilder();
        for (int i = 0; i < palabraSecreta.length(); i++) {
            mascara.append("_ ");
        }
        // Historial dinámico de letras
        StringBuilder historial = new StringBuilder();

        System.out.println("\n¡Hola, " + nombreJugador + "! Adivina la palabra secreta.");
        System.out.println("Escribe una letra por turno o RENDIRSE para abandonar.");

        while (intentosRestantes > 0 && !juegoGanado) {
            turnos++;
            System.out.println("\n----------------------------------");
            System.out.println("Palabra:   " + mascara);
            System.out.println("Letras usadas: " + (historial.length() == 0 ? "(ninguna)" : historial));
            System.out.println("Intentos restantes: " + intentosRestantes + " / " + MAX_INTENTOS);


            if (intentosRestantes == 1 && !pistaMostrada) {
                System.out.println("💡 Pista: la palabra empieza con '"
                        + palabraSecreta.substring(0, 1) + "'.");
                pistaMostrada = true;
            }

            System.out.print("Ingrese una letra: ");
            String entrada = scanner.nextLine().trim().toUpperCase();


            if (entrada.length() == 0) {
                System.out.println("⚠ No ingresó nada.");
                turnos--;
                continue;
            }


            if (entrada.equals("RENDIRSE")) {
                rendido = true;
                break;
            }


            if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                System.out.println("⚠ Ingrese una sola letra válida (A-Z).");
                turnos--;
                continue;
            }

            ultimaLetra = entrada.charAt(0);


            if (historial.indexOf(String.valueOf(ultimaLetra)) != -1) {
                System.out.println("⚠ Ya usó la letra '" + ultimaLetra + "'. Intente otra.");
                turnos--;
                continue;
            }

            historial.append(ultimaLetra).append(' ');
            totalIntentos++;


            boolean acierto = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                String letraSecreta = String.valueOf(palabraSecreta.charAt(i));
                if (letraSecreta.equalsIgnoreCase(String.valueOf(ultimaLetra))) {
                    mascara.setCharAt(i * 2, ultimaLetra);
                    acierto = true;
                }
            }

            if (acierto) {
                aciertos++;
            } else {
                intentosRestantes--;
            }


            System.out.println(acierto
                    ? "✔ ¡Bien! La letra '" + ultimaLetra + "' está en la palabra."
                    : "✘ La letra '" + ultimaLetra + "' no está en la palabra.");

            // Victoria: ya no hay guiones
            if (mascara.indexOf("_") == -1) {
                juegoGanado = true;
                break;
            }
        }


        if (juegoGanado) {
            puntaje += intentosRestantes * 10.0;
            int fallos = MAX_INTENTOS - intentosRestantes;
            double bonoVelocidad = turnos <= palabraSecreta.length() + 2 ? 10.0 : 0.0;
            double bonoSinFallos = fallos == 0 ? 20.0 : 0.0;
            puntaje += bonoVelocidad + bonoSinFallos;
        } else {
            puntaje = 0.0;
        }

        partidasJugadas++;
        if (juegoGanado) {
            partidasGanadas++;
            if (puntaje > mejorPuntaje) {
                mejorPuntaje = puntaje;
            }
        } else {
            partidasPerdidas++;
        }

        String estadoFinal = juegoGanado ? "¡VICTORIA!" : (rendido ? "RENDICIÓN" : "DERROTA");
        mostrarResumen(nombreJugador, estadoFinal, palabraSecreta,
                intentosRestantes, aciertos, totalIntentos, puntaje);
    }


    static void mostrarResumen(String jugador, String estado, String palabra,
                               int intentosRestantes, int aciertos,
                               int totalIntentos, double puntaje) {

        double porcentaje = totalIntentos == 0 ? 0.0 : (double) aciertos / totalIntentos * 100;

        System.out.println();
        System.out.printf("====================================================%n");
        System.out.printf("RESUMEN DE LA PARTIDA%n");
        System.out.printf("====================================================%n");
        System.out.printf("%-20s %s%n", "Jugador:", jugador);
        System.out.printf("%-20s %s%n", "Estado Final:", estado);
        System.out.printf("%-20s %s%n", "Palabra Secreta:", palabra);
        System.out.printf("%-20s %d / %d%n", "Intentos Restantes:", intentosRestantes, MAX_INTENTOS);
        System.out.printf("%-20s %.2f%%%n", "Porcentaje Aciertos:", porcentaje);
        System.out.printf("%-20s %.2f pts%n", "Puntaje Final:", puntaje);
        System.out.printf("====================================================%n");
    }

    static void mostrarEstadisticas() {
        System.out.println();
        System.out.printf("==============================%n");
        System.out.printf("ESTADÍSTICAS DE LA SESIÓN%n");
        System.out.printf("==============================%n");
        System.out.printf("%-20s %d%n", "Partidas jugadas:", partidasJugadas);
        System.out.printf("%-20s %d%n", "Ganadas:", partidasGanadas);
        System.out.printf("%-20s %d%n", "Perdidas:", partidasPerdidas);
        System.out.printf("%-20s %.2f pts%n", "Mejor puntaje:", mejorPuntaje);
        System.out.printf("==============================%n");
    }
}