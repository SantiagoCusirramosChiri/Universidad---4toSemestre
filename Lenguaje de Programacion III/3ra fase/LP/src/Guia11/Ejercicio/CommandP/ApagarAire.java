package Guia11.Ejercicio.CommandP;

public class ApagarAire implements Command{
    private AireAcondicionado aire;

    public ApagarAire(AireAcondicionado aire) {
        this.aire = aire;
    }

    public void ejecutar() {
        aire.apagar();
    }

    public void deshacer() {
        aire.encender();
    }
}
