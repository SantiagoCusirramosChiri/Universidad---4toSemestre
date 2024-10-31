package Ejercicio;

import java.util.Scanner;

public class Menu {

    protected Scanner scanner = new Scanner(System.in);
    protected TableManagement tableManagement = new TableManagement();
    private String contraseña = "xdxdxd";

    public void mostrarMenu() {
        while (true) {

            System.out.println("\nSeleccione una tabla:");
            System.out.println("1. Pagos");
            System.out.println("2. Clientes");
            System.out.println("3. Productos");
            System.out.println("4. Proveedores");
            System.out.println("5. Ordenes");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    menuPagos();
                    break;

                case 2:
                    menuClientes();
                    break;

                case 3:
                    menuProductos();
                    break;

                case 4:
                    menuProveedores();
                    break;

                case 5:
                    menuOrdenes();
                    break;

                case 0:
                    System.out.println("Salio del programa");
                    return;

                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
                    break;

            }

        }

    }

    private boolean validarContraseña() {

        System.out.print("Ingrese la contraseña para continuar: ");
        String input = scanner.nextLine();
        return input.equals(contraseña);

    }

    private void menuPagos() {

        while (true) {

            System.out.println("\nMenú Pagos:");
            System.out.println("1. Insertar Pago");
            System.out.println("2. Actualizar Pago");
            System.out.println("3. Borrar Pago");
            System.out.println("4. Mostrar Pagos");
            System.out.println("0. Volver al menú principal");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    if (validarContraseña()) {

                        System.out.print("ID Orden: ");
                        int idOrden = scanner.nextInt();

                        System.out.print("Monto: ");
                        double monto = scanner.nextDouble();

                        tableManagement.insertarPago(idOrden, monto);

                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }

                    break;

                case 2:

                    if (validarContraseña()) {

                        System.out.print("ID Orden a actualizar: ");
                        int idOrden = scanner.nextInt();

                        System.out.print("Nuevo Monto: ");
                        double monto = scanner.nextDouble();

                        tableManagement.actualizarPago(idOrden, monto);

                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }

                    break;

                case 3:

                    if (validarContraseña()) {

                        System.out.print("ID Orden a borrar: ");
                        int idOrden = scanner.nextInt();

                        tableManagement.borrarPago(idOrden);

                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }

                    break;

                case 4:

                    tableManagement.mostrarPagos();
                    break;

                case 0:

                    return;

                default:

                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        }

    }


    private void menuClientes() {

        while (true) {

            // CRUD
            System.out.println("\nMenú Clientes:");
            System.out.println("1. Insertar Cliente");
            System.out.println("2. Actualizar Cliente");
            System.out.println("3. Borrar Cliente");
            System.out.println("4. Mostrar Clientes");
            System.out.println("0. Volver al menú principal");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    if (validarContraseña()) {

                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Correo: ");
                        String correo = scanner.nextLine();

                        System.out.print("Teléfono: ");
                        String telefono = scanner.nextLine();

                        tableManagement.insertarCliente(nombre, correo, telefono);

                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }

                    break;

                case 2:
                    if (validarContraseña()) {

                        System.out.print("ID Cliente a actualizar: ");
                        int idCliente = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nuevo Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Nuevo Correo: ");
                        String correo = scanner.nextLine();

                        System.out.print("Nuevo Teléfono: ");
                        String telefono = scanner.nextLine();

                        tableManagement.actualizarCliente(idCliente, nombre, correo, telefono);

                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }

                    break;

                case 3:

                    if (validarContraseña()) {

                        System.out.print("ID Cliente a borrar: ");
                        int idCliente = scanner.nextInt();

                        tableManagement.borrarCliente(idCliente);

                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }

                    break;

                case 4:

                    tableManagement.mostrarClientes();
                    break;

                case 0:

                    return;

                default:

                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        }

    }


    private void menuProductos() {

        while (true) {

            System.out.println("\nMenú Productos:");
            System.out.println("1. Insertar Producto");
            System.out.println("2. Actualizar Producto");
            System.out.println("3. Borrar Producto");
            System.out.println("4. Mostrar Productos");
            System.out.println("0. Volver al menú principal");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    if (validarContraseña()) {

                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Precio: ");
                        double precio = scanner.nextDouble();

                        tableManagement.insertarProducto(nombre, precio);

                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }

                    break;

                case 2:

                    if (validarContraseña()) {

                        System.out.print("ID Producto a actualizar: ");
                        int idProducto = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nuevo Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Nuevo Precio: ");
                        double precio = scanner.nextDouble();

                        tableManagement.actualizarProducto(idProducto, nombre, precio);

                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }

                    break;

                case 3:

                    if (validarContraseña()) {

                        System.out.print("ID Producto a borrar: ");
                        int idProducto = scanner.nextInt();

                        tableManagement.borrarProducto(idProducto);

                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }

                    break;

                case 4:

                    tableManagement.mostrarProductos();
                    break;

                case 0:

                    return;

                default:

                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        }

    }


    private void menuProveedores() {

        while (true) {

            System.out.println("\nMenú Proveedores:");
            System.out.println("1. Insertar Proveedor");
            System.out.println("2. Actualizar Proveedor");
            System.out.println("3. Borrar Proveedor");
            System.out.println("4. Mostrar Proveedores");
            System.out.println("0. Volver al menú principal");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    if (validarContraseña()) {

                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Contacto: ");
                        String contacto = scanner.nextLine();

                        tableManagement.insertarProveedor(nombre, contacto);

                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }

                    break;

                case 2:

                    if (validarContraseña()) {

                        System.out.print("ID Proveedor a actualizar: ");
                        int idProveedor = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nuevo Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Nuevo Contacto: ");
                        String contacto = scanner.nextLine();

                        tableManagement.actualizarProveedor(idProveedor, nombre, contacto);

                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }

                    break;

                case 3:

                    if (validarContraseña()) {

                        System.out.print("ID Proveedor a borrar: ");
                        int idProveedor = scanner.nextInt();

                        tableManagement.borrarProveedor(idProveedor);

                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }

                    break;

                case 4:

                    tableManagement.mostrarProveedores();
                    break;

                case 0:

                    return;

                default:

                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        }

    }


    private void menuOrdenes() {

        while (true) {

            System.out.println("\nMenú Ordenes:");
            System.out.println("1. Insertar Orden");
            System.out.println("2. Actualizar Orden");
            System.out.println("3. Borrar Orden");
            System.out.println("4. Mostrar Ordenes");
            System.out.println("0. Volver al menú principal");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    if (validarContraseña()) {

                        System.out.print("ID Cliente: ");
                        int idCliente = scanner.nextInt();

                        System.out.print("Fecha: ");
                        String fecha = scanner.nextLine();

                        tableManagement.insertarOrden(idCliente, fecha);

                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }

                    break;

                case 2:

                    if (validarContraseña()) {

                        System.out.print("ID Orden a actualizar: ");
                        int idOrden = scanner.nextInt();

                        System.out.print("Nuevo ID Cliente: ");
                        int idCliente = scanner.nextInt();

                        System.out.print("Nueva Fecha: ");
                        String fecha = scanner.nextLine();

                        tableManagement.actualizarOrden(idOrden, idCliente, fecha);

                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }

                    break;

                case 3:

                    if (validarContraseña()) {

                        System.out.print("ID Orden a borrar: ");
                        int idOrden = scanner.nextInt();

                        tableManagement.borrarOrden(idOrden);

                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }

                    break;

                case 4:

                    tableManagement.mostrarOrdenes();
                    break;

                case 0:

                    return;

                default:

                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        }

    }


}
