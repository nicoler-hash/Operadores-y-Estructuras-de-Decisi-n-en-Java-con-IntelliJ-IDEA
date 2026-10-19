package org.example;

public class ErrorFallThrough {
    public static void main(String[] args) {
        int opcionCategoria = 1;

        // CORRECCION: agregar break al final de cada case.
        switch (opcionCategoria) {
            case 1:
                System.out.println("Categoría Selección: Lunes (Jornada Laboral)");
                break;
            case 2:
                System.out.println("Categoría Selección: Martes (Jornada Laboral)");
                break;
            case 3:
                System.out.println("Categoría Selección: Miércoles (Jornada Laboral)");
                break;
            default:
                System.out.println("Día no identificado");
        }
    }
}
