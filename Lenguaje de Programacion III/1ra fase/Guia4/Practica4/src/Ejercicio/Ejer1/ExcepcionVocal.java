package Ejercicio.Ejer1;

public class ExcepcionVocal extends Exception {
    public ExcepcionVocal(char c) {
        super("Excepción: El carácter '" + c + "' es una vocal.");
    }
}