package Ejercicio.Ejer6;

import Ejercicio.Ejer6.Exception.ContratoInvalidoException;

public class ContratoAlquiler {
    private int duracion;
    private double montoAlquiler;

    public ContratoAlquiler(int duracion, double montoAlquiler) throws ContratoInvalidoException {
        if (duracion < 0) {
            throw new ContratoInvalidoException("La duración del contrato no puede ser negativa.");
        }
        if (montoAlquiler <= 0) {
            throw new ContratoInvalidoException("El monto del alquiler debe ser positivo.");
        }
        this.duracion = duracion;
        this.montoAlquiler = montoAlquiler;
    }

    public int getDuracion() {
        return duracion;
    }

    public double getMontoAlquiler() {
        return montoAlquiler;
    }

    @Override
    public String toString() {
        return "Duración: " + duracion + " meses, Monto Alquiler: " + montoAlquiler;
    }
}