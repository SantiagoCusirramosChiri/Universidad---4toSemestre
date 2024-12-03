package Guia11.Ejercicio.CommandP;

public class EncenderAire implements Command{
    private AireAcondicionado aire;

    public EncenderAire(AireAcondicionado aire) {
        this.aire = aire;
    }

    public void ejecutar() {
        aire.encender();
    }

    public void deshacer() {
        aire.apagar();
    }
}
