package Ejercicio.Ejercicio12;

import java.io.Serializable;

public class Personaje implements Serializable {

    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {

        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        else {

            this.nombre = nombre;
            this.vida = MenorqueCero(vida, "La vida");
            this.ataque = MenorqueCero(ataque, "El ataque");
            this.alcance = MenorqueCero(alcance, "El alcance");

            if (defensa < 0) {
                throw new IllegalArgumentException("La defensa no puede ser menor a 0.");
            }
            this.defensa = defensa;

        }

    }

    private int MenorqueCero(int valor, String atributo) {
        if (valor <= 0) {
            throw new IllegalArgumentException(atributo + " no puede ser menor o igual a 0.");
        }
        return valor;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setVida(int vida) {
        this.vida = MenorqueCero(vida, "La vida");
    }

    public void setAtaque(int ataque) {
        this.ataque = MenorqueCero(ataque, "El ataque");
    }

    public void setDefensa(int defensa) {

        if (defensa < 0) {
            throw new IllegalArgumentException("La defensa no puede ser menor a 0.");
        }
        this.defensa = defensa;

    }

    public void setAlcance(int alcance) {
        this.alcance = MenorqueCero(alcance, "El alcance");
    }

    @Override
    public String toString() {
        return  ":v" +
                "\nNombre  -> " + nombre +
                "\nVida    -> " + vida +
                "\nAtaque  -> " + ataque +
                "\nDefensa -> " + defensa +
                "\nAlcance -> " + alcance +
                "\nv:";
    }

}
