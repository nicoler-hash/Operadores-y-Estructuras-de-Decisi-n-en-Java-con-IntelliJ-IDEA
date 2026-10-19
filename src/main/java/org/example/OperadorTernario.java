package org.example;

public class OperadorTernario {
    public static void main(String[] args) {
        boolean cookieSesionActiva = true;

        // Version tradicional
        String estadoConexion;
        if (cookieSesionActiva == true) {
            estadoConexion = "ACTIVA";
        } else {
            estadoConexion = "INACTIVA";
        }
        System.out.println("Tradicional: " + estadoConexion);

        // Version con ternario (una sola linea)
        String estadoTernario = cookieSesionActiva ? "ACTIVA" : "INACTIVA";
        System.out.println("Ternario:    " + estadoTernario);
    }
}
