package Ejercicio.Ejer5;

import java.util.ArrayList;
import java.util.List;

public class GestorDeContactos {
    private List<Contacto> contactos;

    public GestorDeContactos() {
        this.contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) throws Exception {
        if (contacto == null) {
            throw new IllegalArgumentException("El contacto no puede ser nulo.");
        }
        if (contacto.getEmail() == null || contacto.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El email del contacto no puede estar vacío.");
        }
        contactos.add(contacto);
    }

    public void modificarContacto(String email, Contacto nuevoContacto) throws Exception {
        for (int i = 0; i < contactos.size(); i++) {
            Contacto contacto = contactos.get(i);
            if (contacto.getEmail().equals(email)) {
                contactos.set(i, nuevoContacto);
                return;
            }
        }
        throw new Exception("Contacto no encontrado.");
    }

    public void eliminarContacto(String email) throws Exception {
        for (int i = 0; i < contactos.size(); i++) {
            Contacto contacto = contactos.get(i);
            if (contacto.getEmail().equals(email)) {
                contactos.remove(i);
                return;
            }
        }
        throw new Exception("Contacto no encontrado.");
    }

    public Contacto buscarContacto(String email) throws Exception {
        for (Contacto contacto : contactos) {
            if (contacto.getEmail().equals(email)) {
                return contacto;
            }
        }
        throw new Exception("Contacto no encontrado.");
    }

    public void listarContactos() {
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    public void menuGestionContactos() {
        System.out.println("\n--- Menú de Gestion de Contactos ---");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Modificar contacto");
        System.out.println("3. Eliminar contacto");
        System.out.println("4. Buscar contacto");
        System.out.println("5. Listar contactos");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opcion: ");
    }
}