package Guia11.Ejercicio.Observer;

public interface Sujeto {
    void suscribir(Clientes cliente);
    void desuscribir(Clientes cliente);
    void notificar();
    void setMensaje(String mensaje);
}
