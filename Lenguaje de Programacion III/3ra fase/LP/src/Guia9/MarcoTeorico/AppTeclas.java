package Guia9.MarcoTeorico;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

public class AppTeclas {
    public static void main(String[] args) {
        MarcoDemoTeclas marcoDemoTeclas = new MarcoDemoTeclas();
        marcoDemoTeclas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoDemoTeclas.setSize(350, 100);
        marcoDemoTeclas.setVisible(true);
    }
}

class MarcoDemoTeclas extends JFrame implements KeyListener{
    private String linea1 = "";
    private String linea2 = "";
    private String linea3 = "";
    private JTextArea areaTexto;

    public MarcoDemoTeclas() {
        super("Demostracion de los eventos de pulsacion de teclas");
        areaTexto = new JTextArea(10,15);
        areaTexto.setText("Oprima cualquier tecla en el teclado GG: ");
        areaTexto.setEnabled(false);
        areaTexto.setDisabledTextColor(Color.BLUE);
        add(areaTexto);
        addKeyListener(this);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        linea1 = String.format("Tecla oprimida: %s" , KeyEvent.getKeyText(e.getKeyCode()));
        establecerLinea2y3(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        linea1 = String.format("Tecla liberada: %s" , KeyEvent.getKeyText(e.getKeyCode()));
        establecerLinea2y3(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        linea1 = String.format("Tecla oprimida: %s", e.getKeyChar());
        establecerLinea2y3(e);
    }

    private void establecerLinea2y3(KeyEvent e) {
        linea2 = String.format("Esta tecla %s esta en accion ", (e.isActionKey() ? "" : "no "));
        String temp = KeyEvent.getModifiersExText(e.getModifiersEx());

        linea3 = String.format("Teclas modificadas oprimidas: %s" , (temp.equals("") ? "ninguna" : temp));
        areaTexto.setText(String.format("%s\n%s\n%s\n%s\n", linea1, linea2, linea3, linea2));
    }
}