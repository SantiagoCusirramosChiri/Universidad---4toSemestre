package Guia11.Ejercicio.CommandP;

public class ApagarLuz implements Command {
    private Luz luz;
    
    public ApagarLuz(Luz luz) {
        this.luz = luz;
    }
    
    public void ejecutar() {
        luz.apagar();
    }
    
    public void deshacer() {
        luz.encender();
    }
}
