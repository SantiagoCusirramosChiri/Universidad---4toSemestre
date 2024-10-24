package MarcoTeorico;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

class Persona implements Serializable {
    private static final long serialVersionUID = 1L; // Versión de serialización
    private String nombre;
    private int edad;
    // Constructor

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    // Método toString
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}

class GuardarPersonas {
    public static void main(String[] args) {

        // Crear objetos de Persona
        Persona p1 = new Persona("Alice", 30);
        Persona p2 = new Persona("Bob", 25);

        // Guardar los objetos en un archivo
        try (FileOutputStream fos = new FileOutputStream("personas.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(p1);
            oos.writeObject(p2);
            System.out.println("Personas guardadas en el archivo.");

        } catch (IOException e) {
            System.out.println("Error al guardar las personas: " + e.getMessage());
        }
    }
}

class CargarPersonas {
    public static void main(String[] args) {

        // Cargar los objetos desde un archivo
        try (FileInputStream fis = new FileInputStream("personas.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Persona p1 = (Persona) ois.readObject();
            Persona p2 = (Persona) ois.readObject();
            System.out.println("Personas cargadas desde el archivo:");
            System.out.println(p1);
            System.out.println(p2);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar las personas: " + e.getMessage());
        }
    }
}