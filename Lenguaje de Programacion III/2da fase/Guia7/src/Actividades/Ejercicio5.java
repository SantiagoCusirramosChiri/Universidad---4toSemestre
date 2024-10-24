package Actividades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class Persona {

    private String nombre;
    private String telefono;
    private String direccion;

    public Persona(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}

class ArrayPersona {
    public Persona[] arreglo;
    final int max = 128;
    int tamano = 0;

    public ArrayPersona() {
        this.arreglo = new Persona[this.max];
    }

    public void printArray(String nombre) {
        for (int i = 0; i < this.tamano; i++) {
            if (this.arreglo[i].getNombre().equals(nombre)) {
                System.out.println(this.arreglo[i].toString());
            }
        }
    }

    public void addArray(Persona persona) {
        if (this.tamano == this.max) {
            System.exit(1);
        }
        this.arreglo[this.tamano++] = persona;
    }
}

class Agenda {
    ArrayPersona lista;
    FileInputStream agendaFile;
    final int longLinea = 32;

    public Agenda() {
        this.lista = cargarContactos();
    }

    public void bucle() {
        String nombre;
        System.out.println("Introduzca el nombre: ");

        try {
            while (!"".equals(nombre = leeEntrada(System.in))) {
                lista.printArray(nombre);
                System.out.println("Introduzca el nombre: ");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private String leeEntrada(InputStream entrada) throws IOException {
        byte[] chars = new byte[longLinea];
        int contador = 0;

        while (contador < longLinea && (chars[contador++] = (byte) entrada.read()) != '\n') {
            if (chars[contador - 1] == -1) {
                return null;
            }
        }
        return new String(chars, 0, contador -1);

    }

    private Persona cargarAgenda() throws IOException {
        String nombre = leeEntrada(System.in);
        if (nombre == null) {
            return null;
        }
        String telefono = leeEntrada(System.in);
        String direccion = leeEntrada(System.in);
        return new Persona(nombre, telefono, direccion);
    }

    private ArrayPersona cargarContactos() {
        ArrayPersona directorio = new ArrayPersona();
        Persona nuevaPersona;

        try{
            agendaFile = new FileInputStream("agenda.txt");
            while (true) {
                nuevaPersona = cargarAgenda();
                if (nuevaPersona == null) {
                    return directorio;
                }
                directorio.addArray(nuevaPersona);
            }

        } catch (FileNotFoundException e) {
            System.out.println("No hay archivo de agenda \n" + e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error en la carga de los contactos\n" + e.getMessage());
            System.exit(1);
        }
        return directorio;
    }
}

class AppContactos {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.bucle();
    }
}