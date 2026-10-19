package org.example;

public class Seccion1Operadores {
    public static void main(String[] args) {
        // Cada fila parte de: int x = 7; boolean flag = false;

        // Fila 1
        int seg = 86400 % 3600;
        System.out.println("1) seg = " + seg);                       // 0

        // Fila 2
        int x = 7;
        int y = ++x + x++;   // ++x -> 8 ; x++ devuelve 8 y luego x = 9
        System.out.println("2) y = " + y + " | x = " + x);          // y=16, x=9

        // Fila 3
        double div1 = 15 / 2;      // division entera 7 -> 7.0
        double div2 = 15.0 / 2;    // 7.5
        System.out.println("3) div1 = " + div1 + " | div2 = " + div2);

        // Fila 4
        x = 7;
        boolean flag = false;
        boolean res = flag && (++x > 0);  // cortocircuito: ++x NO se ejecuta
        System.out.println("4) res = " + res + " | x = " + x);      // false, x=7
    }
}
