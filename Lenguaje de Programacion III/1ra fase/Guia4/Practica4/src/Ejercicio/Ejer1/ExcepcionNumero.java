package Ejercicio.Ejer1;

public class ExcepcionNumero extends Exception {
    public ExcepcionNumero(char c) {
        super("Excepción: El carácter '" + c + "' es un número.");
    }
}
