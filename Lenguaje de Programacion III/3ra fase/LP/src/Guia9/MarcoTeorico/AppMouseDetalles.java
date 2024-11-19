package Guia9.MarcoTeorico;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AppMouseDetalles {
    public static void main(String[] args) {
        MarcoDetallesRaton marcoDetallesRaton = new MarcoDetallesRaton();
        marcoDetallesRaton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoDetallesRaton.setSize(400, 150);
        marcoDetallesRaton.setVisible(true);
    }
}

class MarcoDetallesRaton extends JFrame{
    private String detalles;
    private final JLabel barraEstado;

    public MarcoDetallesRaton() {
        super("Clics y botones del raton");
        barraEstado = new JLabel("Hacer clic en el raton");
        add(barraEstado);
        addMouseListener(new ManejadorClicRaton());
    }

    class ManejadorClicRaton extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            detalles = String.format("Se hizo clic %s vez/veces" , e.getClickCount());

            if(e.getButton() == MouseEvent.BUTTON1) {
                detalles+= " con el botonizquierdo del raton";
            }
            if(e.getButton() == MouseEvent.BUTTON2) {
                detalles+= " con el botoncentral del raton";
            }
            if(e.getButton() == MouseEvent.BUTTON3) {
                detalles+= " con el botonderecho del raton";
            }
            barraEstado.setText(detalles);
        }
    }

}
