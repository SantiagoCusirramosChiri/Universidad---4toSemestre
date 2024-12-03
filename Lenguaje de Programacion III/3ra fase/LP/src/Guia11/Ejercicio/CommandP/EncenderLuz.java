package Guia11.Ejercicio.CommandP;

public class EncenderLuz implements Command  {
    private Luz luz;

    public EncenderLuz(Luz luz) {
        this.luz = luz;
    }

    public void ejecutar() {
        luz.encender();
    }

    public void deshacer() {
        luz.apagar();
    }
}
