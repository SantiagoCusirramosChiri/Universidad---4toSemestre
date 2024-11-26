package Guia10.Ejercicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.Serializable;


public class Ejer1_1_Tienda {
    public static void main(String[] args) {
        InterfazTienda tienda = new InterfazTienda();
        tienda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tienda.setSize(600,600);
        tienda.setVisible(true);
    }
}

class InterfazTienda extends JFrame{

    // etiquetas para el ingreso de datos
    private JLabel lNameProduct = new JLabel("Name of the product: ");
    private JLabel lPrice = new JLabel("Cost of the product: ");
    private JLabel lQuantityStock = new JLabel("Apellido: ");
    private JLabel lCategory = new JLabel("Apellido: ");

    //cuadros de txt
    private JTextField txtNameProduct = new JTextField();
    private JTextField txtPrice = new JTextField();
    private JTextField txtQuantityStock = new JTextField();
    private JTextField txtCategory = new JTextField();

    // resetear y mostrar resumen
    private JButton btnReiniciar = new JButton("Reset");
    private JButton btnResumen = new JButton("Show Summary");

    public InterfazTienda() {
        super("Aplicacion de Tienda");
        setLayout(new GridLayout(5,2));



    }

}


class Tienda implements Serializable {
    private String nombre;
    private double precio;
    private int cantidad;
    private String categoria;

    public Tienda(String nombre, double precio, int cantidad, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}