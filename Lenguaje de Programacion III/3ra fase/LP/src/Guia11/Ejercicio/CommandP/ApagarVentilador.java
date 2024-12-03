package Guia11.Ejercicio.CommandP;

public class ApagarVentilador implements Command {
    private Ventilador ventilador;

    public ApagarVentilador(Ventilador ventilador) {
        this.ventilador = ventilador;
    }

    public void ejecutar() {
        ventilador.apagar();
    }

    public void deshacer() {
        ventilador.encender();
    }
}
