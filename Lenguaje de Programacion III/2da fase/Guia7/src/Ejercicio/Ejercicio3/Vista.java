package Ejercicio.Ejercicio3;

import java.util.Scanner;

class VistaEmpleado {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Listar todos los empleados");
        System.out.println("2. Agregar un nuevo empleado");
        System.out.println("3. Buscar empleado por numero");
        System.out.println("4. Eliminar empleado por numero");
        System.out.println("5. Salir");
        System.out.print("Elija una opcion: ");
    }

    public Empleado solicitarDatosEmpleado() {
        System.out.print("Ingrese el numero del empleado: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el sueldo del empleado: ");
        double sueldo = scanner.nextDouble();
        return new Empleado(numero, nombre, sueldo);
    }

    public int solicitarNumeroEmpleado() {
        System.out.print("Ingrese el número del empleado: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEmpleado(Empleado empleado) {
        if (empleado != null) {
            System.out.println(empleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

}