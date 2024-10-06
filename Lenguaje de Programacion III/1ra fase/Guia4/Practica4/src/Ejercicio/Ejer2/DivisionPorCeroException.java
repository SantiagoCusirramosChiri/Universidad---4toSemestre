package Ejercicio.Ejer2;

public class DivisionPorCeroException extends Exception {
    public DivisionPorCeroException() {
        super("Error: No se puede dividir por cero.");
    }
}
