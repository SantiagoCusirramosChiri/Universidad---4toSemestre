package Ejercicio.Ejercicio3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class ControladorEmpleado {
    private final String ARCHIVO = "empleados.dat";
    private List<Empleado> empleados;
    private VistaEmpleado vista;

    public ControladorEmpleado(VistaEmpleado vista) {
        this.vista = vista;
        empleados = leerEmpleados();
    }

    private List<Empleado> leerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            empleados = (List<Empleado>) ois.readObject();

        } catch (FileNotFoundException e) {
            vista.mostrarMensaje("Archivo no encontrado, se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            vista.mostrarMensaje("Error al leer el archivo.");
        }

        return empleados;

    }

    private void guardarEmpleados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(empleados);
            vista.mostrarMensaje("Datos guardados correctamente.");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al guardar el archivo.");
        }
    }

    public void listarEmpleados() {
        if (empleados.isEmpty()) {
            vista.mostrarMensaje("No hay empleados registrados.");
        } else {
            for (Empleado empleado : empleados) {
                vista.mostrarEmpleado(empleado);
            }
        }
    }

    public void agregarEmpleado() {
        Empleado nuevoEmpleado = vista.solicitarDatosEmpleado();
        empleados.add(nuevoEmpleado);
        guardarEmpleados();
    }

    public void buscarEmpleado() {
        int numero = vista.solicitarNumeroEmpleado();
        Empleado empleado = buscarEmpleadoPorNumero(numero);
        vista.mostrarEmpleado(empleado);
    }

    public void eliminarEmpleado() {
        int numero = vista.solicitarNumeroEmpleado();
        Empleado empleado = buscarEmpleadoPorNumero(numero);
        if (empleado != null) {
            empleados.remove(empleado);
            guardarEmpleados();
            vista.mostrarMensaje("Empleado eliminado correctamente.");
        } else {
            vista.mostrarMensaje("Empleado no encontrado.");
        }
    }

    private Empleado buscarEmpleadoPorNumero(int numero) {
        for (Empleado empleado : empleados) {
            if (empleado.getNumero() == numero) {
                return empleado;
            }
        }
        return null;
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarNumeroEmpleado();
            switch (opcion) {
                case 1:
                    listarEmpleados();
                    break;
                case 2:
                    agregarEmpleado();
                    break;
                case 3:
                    buscarEmpleado();
                    break;
                case 4:
                    eliminarEmpleado();
                    break;
                case 5:
                    vista.mostrarMensaje("Saliendo del programa...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        } while (opcion != 5);
    }
}

