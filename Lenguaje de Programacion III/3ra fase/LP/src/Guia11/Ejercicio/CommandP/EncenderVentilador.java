package Guia11.Ejercicio.CommandP;

public class EncenderVentilador  implements Command {
    private Ventilador ventilador;

    public EncenderVentilador(Ventilador ventilador) {
        this.ventilador = ventilador;
    }

    public void ejecutar() {
        ventilador.encender();
    }

    public void deshacer() {
        ventilador.apagar();
    }
}
