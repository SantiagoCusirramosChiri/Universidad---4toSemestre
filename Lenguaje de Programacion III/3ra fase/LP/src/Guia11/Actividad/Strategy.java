package Guia11.Actividad;

//1. Interfaz Strategy
interface DiscountStrategy {
    double applyDiscount(double price);
}

//2. Implementaciones concretas de la estrategia
class NoDiscount implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price; // No hay descuento.
    }
}

class TenPercentDiscount implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.9; // 10% de descuento.
    }
}

class SpecialDiscount implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.8; // 20% de descuento.
    }
}

//3. Contexto que usa la estrategia
class PriceCalculator {
    private DiscountStrategy discountStrategy;

    //Permite cambiar la estrategia en tiempo de ejecución
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculatePrice(double price) {
        return discountStrategy.applyDiscount(price);
    }
}

// 4. Uso en el programa principal
class StrategyExample {
    public static void main(String[] args) {
        PriceCalculator calculator = new
                PriceCalculator();

        // Estrategia: Sin descuento
        calculator.setDiscountStrategy(new NoDiscount());
        System.out.println("Precio sin descuento: " + calculator.calculatePrice(100.0));

        // Estrategia: 10% de descuento
        calculator.setDiscountStrategy(new TenPercentDiscount());
        System.out.println("Precio con 10% de descuento: " + calculator.calculatePrice(100.0));

        // Estrategia: Descuento especial
        calculator.setDiscountStrategy(new SpecialDiscount());
        System.out.println("Precio con descuento especial: " +
        calculator.calculatePrice(100.0));
    }
}
