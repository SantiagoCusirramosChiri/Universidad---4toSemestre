package Guia9.MarcoTeorico;

import javax.swing.JFrame;

public class GUIJFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mi Ventana");
        frame.setSize(400, 300); // Establecer ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Configura el comportamiento al cerrar el tamaño la
        frame.setVisible(true); // Hacer que la ventana ventana de la sea visible
    }
}