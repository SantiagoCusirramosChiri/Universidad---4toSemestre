package Ejercicio.Ejer6;

import Ejercicio.Ejer6.Exception.DatosInvalidosException;

public class Propiedad {
    private String direccion;
    private double precio;
    private double tamaño;

    public Propiedad(String direccion, double precio, double tamaño) throws DatosInvalidosException {
        if (precio <= 0) {
            throw new DatosInvalidosException("El precio debe ser positivo.");
        }
        if (tamaño <= 0) {
            throw new DatosInvalidosException("El tamaño debe ser positivo.");
        }
        this.direccion = direccion;
        this.precio = precio;
        this.tamaño = tamaño;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public double getTamaño() {
        return tamaño;
    }

    @Override
    public String toString() {
        return "Dirección: " + direccion + ", Precio: " + precio + ", Tamaño: " + tamaño;
    }
}
