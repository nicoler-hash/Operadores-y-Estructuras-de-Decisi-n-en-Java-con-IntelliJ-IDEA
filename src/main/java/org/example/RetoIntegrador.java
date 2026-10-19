package org.example;

public class RetoIntegrador {
    static double calcularTotal(int cantidad, String tipoCliente, String cupon) {
        double subtotalBase = cantidad * 250.00;

        double porcentajeDescuento = switch (tipoCliente) {
            case "VIP" -> 0.20;
            case "REGULAR" -> 0.10;
            case "NUEVO" -> 0.05;
            default -> 0.0;
        };
        double subtotalConDescuento = subtotalBase - (subtotalBase * porcentajeDescuento);

        double descuentoCupon = 0.0;
        if (cupon.equals("PROMO1 año") && subtotalConDescuento >= 500.00) {
            descuentoCupon = 50.00;
        }

        double baseImponible = subtotalConDescuento - descuentoCupon;
        double iva = baseImponible * 0.16;
        double total = baseImponible + iva;

        System.out.printf("Subtotal base: %.2f | Con descuento: %.2f | Cupon: -%.2f | Base imponible: %.2f | IVA: %.2f%n",
                subtotalBase, subtotalConDescuento, descuentoCupon, baseImponible, iva);
        return total;
    }

    public static void main(String[] args) {
        System.out.println("--- Caso A ---");
        System.out.printf("Total a pagar = $%.2f (esperado 638.00)%n", calcularTotal(3, "VIP", "PROMO1 año"));
        System.out.println("--- Caso B ---");
        System.out.printf("Total a pagar = $%.2f (esperado 275.50)%n", calcularTotal(1, "NUEVO", "PROMO1 año"));
    }
}
