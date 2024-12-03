package Guia11.Ejercicio.Strategy;

import java.util.*;
class DescuentoPorcentual implements DescuentoStrategy {
    public double calcularPrecio(List<Producto> productos) {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        if (productos.size() >= 2) {
            total *= 0.7; // 30% de descuento si hay 2 o más
        }
        return total;
    }
}