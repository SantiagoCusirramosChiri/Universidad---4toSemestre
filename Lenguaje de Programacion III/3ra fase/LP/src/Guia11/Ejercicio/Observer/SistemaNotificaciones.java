package Guia11.Ejercicio.Observer;

public class SistemaNotificaciones {
    public static void main(String[] args) {
        Notificacion notificacion = new Notificacion();
        Clientes usuario1 = new Clientes("Alice");
        Clientes usuario2 = new Clientes("Bob");
        notificacion.suscribir(usuario1);
        notificacion.setMensaje("¡Nueva promoción del 50% en productos!");
        notificacion.desuscribir(usuario1);
        notificacion.setMensaje("Actualización de productos disponible.");
        notificacion.SeguirPagina(usuario2);
    }
}
