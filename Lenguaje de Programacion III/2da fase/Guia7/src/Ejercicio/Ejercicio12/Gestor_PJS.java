package Ejercicio.Ejercicio12;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class Gestor_PJS {

    private ArrayList<Personaje> personajes;
    private String archivo = "Contenedor.bin";

    public Gestor_PJS() {
        personajes = new ArrayList<>();
    }

    public Optional<Personaje> buscarPJ(String nombre) {
        return personajes.stream().filter(p -> p.getNombre().equalsIgnoreCase(nombre)).findFirst();
    }

    public void agregarPJ(Personaje p) {

        if (buscarPJ(p.getNombre()).isPresent()) {
            System.out.println("El personaje ya existe: " + p.getNombre());
        }else {

            personajes.add(p);
            System.out.println("Personaje agregado: " + p.getNombre());
        }
    }

    public void eliminarPersonaje(String nombre) {

        Optional<Personaje> personaje = buscarPJ(nombre);

        if (personaje.isPresent()) {
            personajes.remove(personaje.get());
            System.out.println("Personaje eliminado: " + nombre);

        }

        else {
            System.out.println("Personaje no encontrado: " + nombre);
        }

    }

    public void modificarPersonaje(String nombre, int nuevaVida, int nuevoAtaque, int nuevaDefensa, int nuevoAlcance) {
        Optional<Personaje> personaje = buscarPJ(nombre);

        if (personaje.isPresent()) {

            Personaje p = personaje.get();
            p.setVida(nuevaVida);
            p.setAtaque(nuevoAtaque);
            p.setDefensa(nuevaDefensa);
            p.setAlcance(nuevoAlcance);
            System.out.println("Personaje modificado: " + p);

        }

        else {
            System.out.println("Personaje no encontrado: " + nombre);
        }

    }

    public void listarPersonajes() {

        if (personajes.isEmpty()) {
            System.out.println("No hay personajes.");
        }

        else {

            for (Personaje p : personajes) {
                System.out.println(p);
            }

        }

    }

    public void guardarPersonajes() {

        try (ObjectOutputStream input = new ObjectOutputStream(new FileOutputStream(archivo))) {
            input.writeObject(personajes);
            System.out.println("Personajes guardados.");
        }

        catch (IOException e) {
            System.out.println("Error");
        }

    }

    public void cargarPersonajes() {

        try (ObjectInputStream output = new ObjectInputStream(new FileInputStream(archivo))) {
            personajes = (ArrayList<Personaje>) output.readObject();
            System.out.println("Personajes cargados.");
        }

        catch (IOException e) {
            System.out.println("Error");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        int vida_prom = 0;
        int ataque_prom = 0;
        int defensa_prom = 0;
        int alcance_prom = 0;
        int cantidad = personajes.size();

        for (Personaje p : personajes) {

            vida_prom += p.getVida();
            ataque_prom += p.getAtaque();
            defensa_prom += p.getDefensa();
            alcance_prom += p.getAlcance();

        }

        vida_prom /= cantidad;
        ataque_prom /= cantidad;
        defensa_prom /= cantidad;
        alcance_prom /= cantidad;

        return "Cantidad de PJS -> " + cantidad +
                "\n Vida promedio    -> " + vida_prom +
                "\n Ataque promedio  -> " + ataque_prom +
                "\n Defensa promedio -> " + defensa_prom +
                "\n Alcance promedio -> " + alcance_prom;

    }
}