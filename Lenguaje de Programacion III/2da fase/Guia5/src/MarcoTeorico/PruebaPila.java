package MarcoTeorico;

public class PruebaPila {
    private double[] elementosDouble = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6 };
    private int[] elementosInteger = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
    private Pila<Double> pilaDouble;
    private Pila<Integer> pilaInteger;

    public void pruebaPilas() {
        pilaDouble = new Pila<Double>(5);
        pilaInteger = new Pila<Integer>(10);
        pruebaPushDouble();
        pruebaPopDouble();
        pruebaPushInteger();
        pruebaPopInteger();
    }

    public void pruebaPushDouble() {
        try {
            System.out.println("\nMetiendo elementos en pilaDouble");
            for (double elemento : elementosDouble) {
                System.out.printf(" %.1f ", elemento);
                pilaDouble.push(elemento);
            }
        } catch (ExcepcionPilaLlena excepcionPilaLlena) {
            System.err.println();
            excepcionPilaLlena.printStackTrace();
        }
    }

    public void pruebaPopDouble() {
        try {
            System.out.println("\nSacando elementos de pilaDouble");
            double valorASacar;
            while (true) {
                valorASacar = pilaDouble.pop();
                System.out.printf("%.1f ", valorASacar);
            }
        } catch (ExcepcionPilaVacia excepcionPilaVacia) {
            System.err.println();
            excepcionPilaVacia.printStackTrace();
        }
    }

    public void pruebaPushInteger() {
        try {
            System.out.println("\nMetiendo elementos a pilaInteger");
            for (int elemento : elementosInteger) {
                System.out.printf(" %d ", elemento);
                pilaInteger.push(elemento);
            }
        } catch (ExcepcionPilaLlena excepcionPilaLlena) {
            System.err.println();
            excepcionPilaLlena.printStackTrace();
        }
    }

    public void pruebaPopInteger() {
        try {
            System.out.println("\nSacando elementos de pilaInteger");
            int valorASacar;
            while (true) {
                valorASacar = pilaInteger.pop();
                System.out.printf("%d ", valorASacar);
            }
        } catch (ExcepcionPilaVacia excepcionPilaVacia) {
            System.err.println();
            excepcionPilaVacia.printStackTrace();
        }
    }

    public static void main(String args[]) {
        PruebaPila aplicacion = new PruebaPila();
        aplicacion.pruebaPilas();
    }
}
