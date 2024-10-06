package Ejercicio.Ejer3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Numero numero;

        while (true) {
            try {
                System.out.print("Introduce un número: ");
                double valor = scanner.nextDouble();

                numero = new Numero(valor);
                System.out.println("Número Seleccionado: " + numero.getValor());

            } catch (IllegalArgumentException e) {
                System.out.println("Excepción capturada: " + e.getMessage());
                System.out.print("¿Deseas salir del programa? (Y/N): ");
                String salida = scanner.next();

                if (salida.equalsIgnoreCase("Y")) {
                    System.out.println("Saliendo del programa...");
                    break;
                }
            }
        }
        scanner.close();
    }
}
