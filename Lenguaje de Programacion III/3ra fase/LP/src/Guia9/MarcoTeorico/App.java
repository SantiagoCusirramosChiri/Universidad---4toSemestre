package Guia9.MarcoTeorico;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

class AppCTM {
    public static void main(String[] args)
    {
        CampoTextoMarco campoTextoMarco = new CampoTextoMarco();
        campoTextoMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        campoTextoMarco.setSize(300, 250);
        campoTextoMarco.setVisible(true);
    }
}// Fin de App Prueba Label

class CampoTextoMarco extends JFrame{
    private final JTextField campoTexto1;
    private final JTextField campoTexto2;
    private final JTextField campoTexto3;
    private final JPasswordField campoContrasenia;

    public CampoTextoMarco() {
        setLayout(new FlowLayout());
        campoTexto1 = new JTextField(10);
        add(campoTexto1);

        campoTexto2 = new JTextField("Escriba aqui un texto XYZ");
        add(campoTexto2);

        campoTexto3 = new JTextField("No se xq no es editable, ahora ya se",10);
        campoTexto3.setEditable(false);
        add(campoTexto3);

        campoContrasenia = new JPasswordField("TEXTO EN ****** ");
        add(campoContrasenia);

        ManejadorCampoTexto manejador = new ManejadorCampoTexto();
        campoTexto1.addActionListener(manejador);
        campoTexto2.addActionListener(manejador);
        campoTexto3.addActionListener(manejador);
        campoContrasenia.addActionListener(manejador);

    }

    private class ManejadorCampoTexto implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento) {
            String cadena = "";

            // el usuario oprimió Intro en el objeto JTextField campoTexto1
            if (evento.getSource() == campoTexto1)
                cadena = String.format("campoTexto1: %s", evento.getActionCommand());

            // el usuario oprimió Intro en el objeto JTextField campoTexto2
            else if (evento.getSource() == campoTexto2)
                cadena = String.format("campoTexto2: %s", evento.getActionCommand() );

            // el usuario oprimió Intro en el objeto JTextField campoTexto3
            else if (evento.getSource() == campoTexto3)
                cadena = String.format("campoTexto3: %s", evento.getActionCommand());

            // el usuario oprimió Intro en el objeto JTextField campoContrasenia
            else if (evento.getSource() == campoContrasenia)
                cadena = String.format("campoContrasenia: %s", evento.getActionCommand());
            // muestra el contenido del objeto JTextField
            JOptionPane.showMessageDialog(null, cadena);

        }
    }



}
