package Guia11.Ejercicio.Observer;

// Observador
class  Clientes implements Observador{
    private String nombre;

    public Clientes(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Hola " + nombre + ", tienes una nueva notificación: " + mensaje);
    }
}
