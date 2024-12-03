package Guia11.Ejercicio.Strategy;

import java.util.*;
class CalculadoraDePrecios {
    private List<Producto> productos;
    private Scanner scanner;

    public CalculadoraDePrecios() {
        this.productos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        inicializarProductos();
    }

    private void inicializarProductos() {
        productos.add(new Producto("Laptop", 1000));
        productos.add(new Producto("Teclado", 50));
        productos.add(new Producto("Teclado", 50));
        productos.add(new Producto("Mouse", 25));
    }

    public void ejecutar() {
        mostrarMenu();
        int opcion = scanner.nextInt();
        DescuentoStrategy estrategia = seleccionarEstrategia(opcion);
        if (estrategia == null) {
            System.out.println("Opción inválida.");
            return;
        }
        double precioFinal = estrategia.calcularPrecio(productos);
        System.out.println("El precio final es: $" + precioFinal);
    }

    private void mostrarMenu() {
        System.out.println("Seleccione el tipo de descuento:");
        System.out.println("1. Sin descuento");
        System.out.println("2. Descuento fijo (10%)");
        System.out.println("3. Descuento porcentual (30% en 2 o más productos)");
        System.out.println("4. Descuento acumulado (50% al más barato si hay 3 o más productos)");
    }

    private DescuentoStrategy seleccionarEstrategia(int opcion) {
        switch (opcion) {
            case 1:
                return new SinDescuento();
            case 2:
                return new DescuentoFijo();
            case 3:
                return new DescuentoPorcentual();
            case 4:
                return new DescuentoPorcentualAcumulado();
            default:
                return null;
        }
    }
}