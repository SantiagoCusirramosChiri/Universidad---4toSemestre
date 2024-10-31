package Ejercicio;

public class Pago {

    private int idOrden;
    private double monto;

    public Pago(int idOrden, double monto) {

        this.idOrden = idOrden;
        this.monto = monto;

    }

    public int getIdOrden() {
        return idOrden;
    }

    public double getMonto() {
        return monto;
    }

}
