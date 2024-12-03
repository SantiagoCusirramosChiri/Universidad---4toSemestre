package Guia11.Ejercicio.Strategy;

import java.util.*;
class DescuentoFijo implements DescuentoStrategy {
    public double calcularPrecio(List<Producto> productos) {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total * 0.9; // 10% de descuento
    }
}