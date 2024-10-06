package Ejercicio;

import java.util.List;

class Par<F,S> {
    // ejercicio 1
    private F firstN;
    private S secondN;

    public Par(F firstN, S secondN) {
        this.firstN = firstN;
        this.secondN = secondN;
    }

    public F getFirstN() {
        return firstN;
    }

    public S getSecondN() {
        return secondN;
    }

    public void setFirstN(F firstN) {
        this.firstN = firstN;
    }

    public void setSecondN(S secondN) {
        this.secondN = secondN;
    }

    @Override
    public String toString() {
        return String.format("(Primero: %s, Segundo: %s)", firstN, secondN);
    }

    // ejercicio 2
    public boolean esIgual(Par<F, S> otroPar) {
        if (otroPar == null) {
            return false;
        }

        return this.firstN.equals(otroPar.getFirstN()) &&
                this.secondN.equals(otroPar.getSecondN());
    }

    // ejercicio 3
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par.toString());
    }

    public static void main(String[] args) {
        Contenedor<String, Integer> contenedor = new Contenedor<>();

        // Agregar pares al contenedor
        contenedor.agregarPar("Edad", 30);
        contenedor.agregarPar("Peso", 70);
        contenedor.agregarPar("Altura", 175);

        // Obtener y mostrar un par específico
        Par<String, Integer> parObtenido = contenedor.obtenerPar(1); // Debe devolver ("Peso", 70)
        System.out.println("Par en la posición 1: " + parObtenido);

        // Mostrar todos los pares
        System.out.println("Todos los pares almacenados:");
        contenedor.mostrarContenedor();

        // Obtener la lista completa de pares
        List<Par<String, Integer>> listaCompleta = contenedor.obtenerTodosLosPares();
        System.out.println("Lista completa de pares: " + listaCompleta);
    }

}
