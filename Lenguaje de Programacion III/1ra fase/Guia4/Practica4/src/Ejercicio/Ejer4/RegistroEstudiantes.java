package Ejercicio.Ejer4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class RegistroEstudiantes {
    private List<Estudiante> estudiantes;

    public RegistroEstudiantes() {
        estudiantes = new ArrayList<>();
    }

public void agregarEstudiante(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del estudiante no puede ser nulo o vacío.");
        }
        estudiantes.add(new Estudiante(nombre));
        System.out.println("Estudiante agregado: " + nombre);
    }

    public Estudiante buscarEstudiante(String nombre) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombre)) {
                return estudiante;
            }
        }
        throw new NoSuchElementException("Estudiante no encontrado: " + nombre);
    }

    public List<Estudiante> obtenerEstudiantes() {
        return estudiantes;
    }
}
