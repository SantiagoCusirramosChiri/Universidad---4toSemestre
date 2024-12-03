package Guia11.Ejercicio.Strategy;

import java.util.*;

class DescuentoPorcentualAcumulado implements DescuentoStrategy {
    public double calcularPrecio(List<Producto> productos) {
        if (productos.size() < 3) {
            double total = 0;
            for (Producto producto : productos) {
                total += producto.getPrecio();
            }
            return total;
        }

        double total = 0;
        double masBarato = productos.get(0).getPrecio(); 
        for (Producto producto : productos) {
            total += producto.getPrecio();
            if (producto.getPrecio() < masBarato) {
                masBarato = producto.getPrecio();
            }
        }
        return total - masBarato * 0.5; // 50% descuento al más barato
    }
}