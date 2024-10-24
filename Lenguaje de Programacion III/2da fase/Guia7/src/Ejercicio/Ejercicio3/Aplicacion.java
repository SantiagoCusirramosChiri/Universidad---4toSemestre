package Ejercicio.Ejercicio3;

class Main {
    public static void main(String[] args) {
        VistaEmpleado vista = new VistaEmpleado();
        ControladorEmpleado controlador = new ControladorEmpleado(vista);
        controlador.iniciar();
    }
}
