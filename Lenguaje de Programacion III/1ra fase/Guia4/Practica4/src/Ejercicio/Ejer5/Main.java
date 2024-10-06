package Ejercicio.Ejer5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorDeContactos gestor = new GestorDeContactos();

        while (true) {
            gestor.menuGestionContactos();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    try {
                        System.out.print("Ingrese el nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el email: ");
                        String email = scanner.nextLine();
                        System.out.print("Ingrese el número de teléfono: ");
                        String numeroTelefono = scanner.nextLine();
                        System.out.print("Ingrese la calle: ");
                        String calle = scanner.nextLine();
                        System.out.print("Ingrese la ciudad: ");
                        String ciudad = scanner.nextLine();
                        System.out.print("Ingrese el código postal: ");
                        String codigoPostal = scanner.nextLine();

                        Telefono telefono = new Telefono(numeroTelefono);
                        Direccion direccion = new Direccion(calle, ciudad, codigoPostal);
                        Contacto contacto = new Contacto(nombre, email, telefono, direccion);

                        gestor.agregarContacto(contacto);
                        System.out.println("Contacto agregado exitosamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Ingrese el email del contacto a modificar: ");
                        String email = scanner.nextLine();

                        System.out.print("Ingrese el nuevo nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el nuevo número de teléfono: ");
                        String numeroTelefono = scanner.nextLine();
                        System.out.print("Ingrese la nueva calle: ");
                        String calle = scanner.nextLine();
                        System.out.print("Ingrese la nueva ciudad: ");
                        String ciudad = scanner.nextLine();
                        System.out.print("Ingrese el nuevo código postal: ");
                        String codigoPostal = scanner.nextLine();

                        Telefono telefono = new Telefono(numeroTelefono);
                        Direccion direccion = new Direccion(calle, ciudad, codigoPostal);
                        Contacto nuevoContacto = new Contacto(nombre, email, telefono, direccion);

                        gestor.modificarContacto(email, nuevoContacto);
                        System.out.println("Contacto modificado exitosamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Ingrese el email del contacto a eliminar: ");
                        String email = scanner.nextLine();
                        gestor.eliminarContacto(email);
                        System.out.println("Contacto eliminado exitosamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Ingrese el email del contacto a buscar: ");
                        String email = scanner.nextLine();
                        Contacto contacto = gestor.buscarContacto(email);
                        System.out.println("Contacto encontrado: " + contacto);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Lista de contactos:");
                    gestor.listarContactos();
                    break;

                case 6:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}