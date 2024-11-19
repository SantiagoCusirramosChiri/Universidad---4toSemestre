package Guia9.Actividad;

import javax.swing.*;
import java.awt.*;

class LayoutExamples {
    public static void main(String[] args) {
        // Ventana con FlowLayout
        JFrame flowFrame = new JFrame("FlowLayout Example");
        flowFrame.setLayout(new FlowLayout());
        flowFrame.add(new JButton("Botón 1"));
        flowFrame.add(new JButton("Botón 2"));
        flowFrame.add(new JButton("Botón 3"));
        flowFrame.setSize(300, 100);
        flowFrame.setVisible(true);

        // Ventana con BorderLayout
        JFrame borderFrame = new JFrame("BorderLayout Example");
        borderFrame.setLayout(new BorderLayout());
        borderFrame.add(new JButton("NORTE"), BorderLayout.NORTH);
        borderFrame.add(new JButton("SUR"), BorderLayout.SOUTH);
        borderFrame.add(new JButton("ESTE"), BorderLayout.EAST);
        borderFrame.add(new JButton("OESTE"), BorderLayout.WEST);
        borderFrame.add(new JButton("CENTRO"), BorderLayout.CENTER);
        borderFrame.setSize(400, 200);
        borderFrame.setVisible(true);

        // Ventana con GridLayout
        JFrame gridFrame = new JFrame("GridLayout Example");
        gridFrame.setLayout(new GridLayout(2, 3)); // 2 filas, 3 columnas
        gridFrame.add(new JButton("1"));
        gridFrame.add(new JButton("2"));
        gridFrame.add(new JButton("3"));
        gridFrame.add(new JButton("4"));
        gridFrame.add(new JButton("5"));
        gridFrame.add(new JButton("6"));
        gridFrame.setSize(300, 150);
        gridFrame.setVisible(true);

        // Configuración común
        flowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        borderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gridFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
