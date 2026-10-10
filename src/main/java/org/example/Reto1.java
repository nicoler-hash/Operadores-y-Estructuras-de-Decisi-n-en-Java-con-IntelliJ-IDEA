package org.example;

public class Reto1 {
    public static void main(String[] args) {
        int edadUsuario = 15;
        System.out.println("Ingrese su edad");
        System.out.println("Edad ingresada: " + edadUsuario + " años\n");

        if (edadUsuario < 12) {
            System.out.println("Categoría: Infante");
            System.out.println("Perfil activado: Requiere tutor de cuenta.");
        } else if (edadUsuario <= 17) {
            System.out.println("Categoría: Adolescente");
            System.out.println("Perfil activado: Acceso restringido a foros comunitarios.");
        } else if (edadUsuario <= 64) {
            System.out.println("Categoría: Adulto");
            System.out.println("Perfil activado: Acceso a funcionalidades estándar.");
        } else {
            System.out.println("Categoría: Adulto Mayor");
            System.out.println("Perfil activado: Acceso con interfaz adaptada.");
        }


    }
}
