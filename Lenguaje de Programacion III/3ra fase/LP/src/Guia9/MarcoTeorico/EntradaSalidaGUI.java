package Guia9.MarcoTeorico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntradaSalidaGUI {
    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("Entrada/Salida Simple");
        frame.setSize(400, 200); // Tamaño de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un panel para organizar los componentes
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new FlowLayout());

        // Crear los componentes
        JLabel etiqueta = new JLabel("Introduce tu nombre: ");
        JTextField campoTexto = new JTextField(20); // Campo de texto para ingresar el nombre
        JButton botonSaludar = new JButton("Saludar"); // Botón para generar la salida
        JLabel salida = new JLabel(""); // Etiqueta para mostrar el mensaje de salida

        // Agregar los componentes al panel
        panel.add(etiqueta);
        panel.add(campoTexto);
        panel.add(botonSaludar);
        panel.add(salida);

        // Acción cuando sehace clic enel botón
        botonSaludar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = campoTexto.getText(); // Obtener el texto ingresado
                if (!nombre.trim().isEmpty()) {
                    salida.setText("¡Hola, " + nombre + "!"); // Mostrar mensaje de salida
                } else {
                    salida.setText("Por favor, ingresa tu nombre."); // Si el campo está vacío
                }
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}