package org.example;

public class ErrorAsignacion {
    public static void main(String[] args) {
        boolean cookieActiva = false;

        // ERROR: (cookieActiva = true) ASIGNA true y siempre entra al if.
        // CORRECCION: usar la variable directamente (o == para comparar).
        if (cookieActiva) {
            System.out.println("Estado de sesión: Sesión del usuario activa.");
        } else {
            System.out.println("Estado de sesión: Sesión inactiva.");
        }
    }
}
