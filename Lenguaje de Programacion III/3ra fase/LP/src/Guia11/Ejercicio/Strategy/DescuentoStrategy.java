package Guia11.Ejercicio.Strategy;

import java.util.*;

interface DescuentoStrategy {
    double calcularPrecio(List<Producto> productos);
}