package Guia11.Ejercicio.CommandP;

import java.util.*;

class ControlRemoto {
    private Command comandoActual;
    private List<Command> historial;

    public ControlRemoto() {
        historial = new ArrayList<>();
    }

    public void setComando(Command comando) {
        comandoActual = comando;
    }

    public void presionarBoton() {
        if (comandoActual != null) {
            comandoActual.ejecutar();
            historial.add(comandoActual);
        }
    }

    public void deshacer() {
        if (!historial.isEmpty()) {
            Command ultimoComando = historial.remove(historial.size() - 1); // Eliminar el último comando
            ultimoComando.deshacer();
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }
}
