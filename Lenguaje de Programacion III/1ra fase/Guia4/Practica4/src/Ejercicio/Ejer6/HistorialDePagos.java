package Ejercicio.Ejer6;

import Ejercicio.Ejer6.Exception.PagoInvalidoException;

import java.util.Date;

public class HistorialDePagos {
    private Date fecha;
    private double monto;

    public HistorialDePagos(Date fecha, double monto) throws PagoInvalidoException {
        if (fecha.after(new Date())) {
            throw new PagoInvalidoException("La fecha del pago no puede ser futura.");
        }
        if (monto < 0) {
            throw new PagoInvalidoException("El monto del pago debe ser positivo.");
        }
        this.fecha = fecha;
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Monto: " + monto;
    }
}
