package org.example.ciclos.seccion5;

import java.util.Scanner;

public class ejerciciointegrador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int CAPACIDAD_MAXIMA = 500;

        int totalUnidades = 0;
        int productosRegistrados = 0;
        int productosDescontinuados = 0;
        double valorInventario = 0;
        int opcion;

        do {
            System.out.println("\n ALMACÉN LOGÍSTICO ");
            System.out.println("1. Registrar Lote de Productos");
            System.out.println("2. Ver Estado del Almacén");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Cantidad de productos del lote: ");
                    int n = sc.nextInt();

                    for (int i = 1; i <= n; i++) {
                        System.out.println("\n-- Producto " + i + " de " + n + " --");

                        System.out.print("¿Está descontinuado? (s/n): ");
                        String resp = sc.next();
                        if (resp.equalsIgnoreCase("s")) {
                            productosDescontinuados++;
                            System.out.println("Producto descontinuado: se omite.");
                            continue;
                        }

                        System.out.print("Precio unitario: $");
                        double precio = sc.nextDouble();
                        while (precio <= 0) {
                            System.out.print("Error: el precio debe ser mayor a cero. Reingrese: $");
                            precio = sc.nextDouble();
                        }

                        System.out.print("Cantidad en stock: ");
                        int stock = sc.nextInt();
                        while (stock <= 0) {
                            System.out.print("Error: el stock debe ser mayor a cero. Reingrese: ");
                            stock = sc.nextInt();
                        }

                        if (totalUnidades + stock > CAPACIDAD_MAXIMA) {
                            System.out.println("¡ALERTA! Sobrecupo: se superaría la capacidad de "
                                    + CAPACIDAD_MAXIMA + " unidades. Se aborta el resto del lote.");
                            break;
                        }

                        totalUnidades += stock;
                        valorInventario += precio * stock;
                        productosRegistrados++;
                        System.out.println("Producto registrado.");
                    }
                    break;
                case 2:
                    System.out.println("\n--- Estado del Almacén ---");
                    System.out.println("Productos registrados: " + productosRegistrados);
                    System.out.println("Productos descontinuados omitidos: " + productosDescontinuados);
                    System.out.println("Unidades almacenadas: " + totalUnidades + " / " + CAPACIDAD_MAXIMA);
                    System.out.printf("Valor total del inventario: $%,.2f%n", valorInventario);
                    break;
                case 3:
                    System.out.println("Cerrando el sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

        sc.close();
    }
}
