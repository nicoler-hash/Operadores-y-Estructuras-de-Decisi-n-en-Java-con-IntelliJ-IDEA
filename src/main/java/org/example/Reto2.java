package org.example;

public class Reto2 {
    static String dictamen(double calificacionFinal, int porcentajeAsistencia, boolean entregoProyectoFinal) {
        if (calificacionFinal >= 70.0 && porcentajeAsistencia >= 80) {
            return "Aprobado";
        } else if (entregoProyectoFinal && calificacionFinal >= 60.0) {
            return "Pendiente de Examen Extraordinario";
        } else {
            return "Reprobado";
        }
    }

    public static void main(String[] args) {
        System.out.println("85.0, 90%, true  -> " + dictamen(85.0, 90, true));   // Aprobado
        System.out.println("75.0, 70%, true  -> " + dictamen(75.0, 70, true));   // Pendiente
        System.out.println("65.0, 90%, true  -> " + dictamen(65.0, 90, true));   // Pendiente
        System.out.println("65.0, 90%, false -> " + dictamen(65.0, 90, false));  // Reprobado
        System.out.println("50.0, 50%, true  -> " + dictamen(50.0, 50, true));   // Reprobado
    }