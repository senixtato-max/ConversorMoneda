package com.conversor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorService service = new ConversorService();
        int opcion;

        do {
            System.out.println("\n=== CONVERSOR DE MONEDA ===");
            System.out.println("1. USD a COP");
            System.out.println("2. COP a USD");
            System.out.println("3. USD a EUR");
            System.out.println("4. EUR a USD");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingrese la cantidad: ");
                double cantidad = scanner.nextDouble();

                try {
                    double resultado = switch (opcion) {
                        case 1 -> service.convertir("USD", "COP", cantidad);
                        case 2 -> service.convertir("COP", "USD", cantidad);
                        case 3 -> service.convertir("USD", "EUR", cantidad);
                        case 4 -> service.convertir("EUR", "USD", cantidad);
                        default -> 0;
                    };
                    System.out.println("Resultado: " + resultado);
                } catch (Exception e) {
                    System.out.println("Error en la conversión");
                }
            }

        } while (opcion != 5);

        System.out.println("Programa finalizado");
    }
}
