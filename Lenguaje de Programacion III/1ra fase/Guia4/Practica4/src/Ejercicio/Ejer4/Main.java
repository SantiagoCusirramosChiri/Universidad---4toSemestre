package Ejercicio.Ejer4;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RegistroEstudiantes registro = new RegistroEstudiantes();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Registro de Estudiantes ---");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    try {
                        registro.agregarEstudiante(nombre);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Introduce el nombre del estudiante a buscar: ");
                    String nombreBuscado = scanner.nextLine();
                    try {
                        Estudiante estudiante = registro.buscarEstudiante(nombreBuscado);
                        System.out.println("Estudiante encontrado: " + estudiante.getNombre());
                    } catch (NoSuchElementException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
}
