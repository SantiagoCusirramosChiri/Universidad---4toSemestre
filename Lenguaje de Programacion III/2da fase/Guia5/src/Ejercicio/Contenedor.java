package Ejercicio;

import java.util.ArrayList;
import java.util.List;

public class Contenedor<F,S> {
    protected List<Par<F,S>> contenedorPares;

    public Contenedor() {
        contenedorPares = new ArrayList();
    }

    //Agregar por atributos
    public void agregarPar(F primero, S segundo) {
        Par<F, S> nuevoPar = new Par<>(primero, segundo);
        contenedorPares.add(nuevoPar);
    }

    //Agregar por objetos directos
    public void agregarPar(Par<F,S> par) {
        contenedorPares.add(par);
    }

    // obtener pares por indice
    public Par<F, S> obtenerPar(int indice) {
        if (indice >= 0 && indice < contenedorPares.size()) {
            return contenedorPares.get(indice);
        }
        throw new IndexOutOfBoundsException("Índice fuera de rango");
    }

    //obtener todos los pares del arreglo
    public List<Par<F, S>> obtenerTodosLosPares() {
        return contenedorPares;
    }

    // mostrar todos los pares
    public void mostrarContenedor() {
        for (Par<F,S> par : contenedorPares ) {
            System.out.printf("%s " + par +"\n");
        }
    }

}
