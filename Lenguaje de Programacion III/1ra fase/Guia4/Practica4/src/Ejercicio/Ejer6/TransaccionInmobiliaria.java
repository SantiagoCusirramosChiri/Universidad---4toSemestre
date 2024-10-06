package Ejercicio.Ejer6;

import Ejercicio.Ejer6.Exception.PrecioInferiorException;

public class TransaccionInmobiliaria {
    private String id;
    private Propiedad propiedad;
    private double precio;

    public TransaccionInmobiliaria(String id, Propiedad propiedad, double precio) throws PrecioInferiorException {
        if (precio < propiedad.getPrecio()) {
            throw new PrecioInferiorException("El precio de la transacción no puede ser menor que el precio de la propiedad.");
        }
        this.id = id;
        this.propiedad = propiedad;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Propiedad: [" + propiedad + "], Precio: " + precio;
    }
}
