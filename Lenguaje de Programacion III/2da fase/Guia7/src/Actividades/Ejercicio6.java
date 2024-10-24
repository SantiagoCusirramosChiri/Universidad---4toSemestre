package Actividades;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.io.Serializable;

class People implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int edad;

    public People(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "People{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}

class Alumno extends People{
    private Fecha fechaMatricula;

    public Alumno (String nif, String nombre, int edad, Fecha fechaMatricula) {
        super(nombre, edad);
        this.fechaMatricula= new Fecha();
        setFechaMatricula (fechaMatricula);

    }

    public Fecha getFechaMatricula () {
        return fechaMatricula;
    }
    public void setFechaMatricula (Fecha fechaMatricula) {
        this.fechaMatricula.setDia(fechaMatricula.getDia());
        this.fechaMatricula.setMes(fechaMatricula.getMes());
        this.fechaMatricula.setAno(fechaMatricula.getAno());
    }
}

class Fecha implements Serializable {
    private int dia;
    private int mes;
    private int ano;

    public Fecha(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Fecha(){}
    public int getDia() {
        return dia;
    }
    public int getMes() {
        return mes;
    }
    public int getAno() {
        return ano;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
}

class Serial5 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        Alumno a;
        Fecha f;

        try {
            fos = new FileOutputStream("alumnos.dat");
            salida = new ObjectOutputStream(fos);  // Corrección realizada

            f = new Fecha(5, 9, 2011);
            a = new Alumno("12345678A", "Lucas González", 20, f);
            salida.writeObject(a);

            f = new Fecha(7, 9, 2011);
            a = new Alumno("98765432B", "Anacleto Jiménez", 19, f);
            salida.writeObject(a);

            f = new Fecha(8, 9, 2011);
            a = new Alumno("782342122", "María Zapata", 21, f);
            salida.writeObject(a);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fos != null) fos.close();
                if (salida != null) salida.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}