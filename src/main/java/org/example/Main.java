package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Operador Residuo ");
        int seg = 86400 % 3600;
        System.out.println("seg = " + seg);

        System.out.println("\n 2. Incremento Prefijo y Posfijo ");
        int x1 = 5;
        int y = ++x1 + x1++;
        System.out.println("y = " + y);
        System.out.println("x final = " + x1);

        System.out.println("\n 3. Promoción Implícita de Tipos ");
        double div1 = 15 / 2;
        double div2 = 15.0 / 2;
        System.out.println("div1 = " + div1);
        System.out.println("div2 = " + div2);

        System.out.println("\n 4. Cortocircuito (Short-Circuit) ");
        int x2 = 5;
        boolean flag = false;
        boolean res = flag && (++x2 > 0);
        System.out.println("res = " + res);
        System.out.println("x no incrementó = " + x2);
    }
}