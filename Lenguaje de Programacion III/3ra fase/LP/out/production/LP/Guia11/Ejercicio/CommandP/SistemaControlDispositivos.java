package Guia11.Ejercicio.CommandP;

public class SistemaControlDispositivos {
    public static void main(String[] args) {
        // Crear dispositivos
        Luz luz = new Luz();
        Ventilador ventilador = new Ventilador();
        AireAcondicionado aire = new AireAcondicionado();

        // Crear comandos
        Command encenderLuz = new EncenderLuz(luz);
        Command apagarLuz = new ApagarLuz(luz);

        Command encenderVentilador = new EncenderVentilador(ventilador);
        Command apagarVentilador = new ApagarVentilador(ventilador);

        Command encenderAire = new EncenderAire(aire);
        Command apagarAire = new ApagarAire(aire);

        // Crear control remoto
        ControlRemoto control = new ControlRemoto();

        // Usar control remoto
        control.setComando(encenderLuz);
        control.presionarBoton();

        control.setComando(encenderVentilador);
        control.presionarBoton();

        control.setComando(encenderAire);
        control.presionarBoton();

        // Deshacer últimas acciones
        control.deshacer();
        control.deshacer();
        control.deshacer();
    }
}

