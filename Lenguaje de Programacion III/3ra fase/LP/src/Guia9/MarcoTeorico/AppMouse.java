package Guia9.MarcoTeorico;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class AppMouse
{
    public static void main(String[] args)
    {
        MarcoRastreadorRaton marcoRastreadorRaton = new MarcoRastreadorRaton();
        marcoRastreadorRaton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoRastreadorRaton.setSize(300, 300);
        marcoRastreadorRaton.setVisible(true);
    }
}

class MarcoRastreadorRaton extends JFrame {
    private final JPanel panelRaton;
    private final JLabel barrEstado;

    public MarcoRastreadorRaton() {
        super("Demostracion del RATON WIIII");
        panelRaton = new JPanel();
        panelRaton.setBackground(Color.BLACK);
        add(panelRaton, BorderLayout.CENTER);

        barrEstado = new JLabel("Raton fuera del panel");
        add(barrEstado, BorderLayout.SOUTH);

        ManejadorRaton manejadorRaton = new ManejadorRaton();
        panelRaton.addMouseListener(manejadorRaton);
        panelRaton.addMouseMotionListener(manejadorRaton);

    }

    private class  ManejadorRaton implements MouseListener, MouseMotionListener{
        @Override
        public void mouseClicked(MouseEvent evento) {
            barrEstado.setText(String.format("Raton fuera del panel: [%s, %d]", evento.getX(), evento.getY()));
        }

        @Override
        public void mousePressed(MouseEvent evento) {
            barrEstado.setText(String.format("Se oprimio en: [%s, %d]", evento.getX(), evento.getY()));
        }

        @Override
        public void mouseReleased(MouseEvent evento) {
            barrEstado.setText(String.format("Se solto en: [%s, %d]", evento.getX(), evento.getY()));
        }

        @Override
        public void mouseEntered(MouseEvent evento)
        {
            barrEstado.setText(String.format("Raton entro en [%d, %d]", evento.getX(), evento.getY()));
            panelRaton.setBackground(Color.GREEN);
        }

        @Override
        public void mouseExited(MouseEvent evento)
        {
            barrEstado.setText("Raton fuera de JPanel");
            panelRaton.setBackground(Color.WHITE);
        }

        @Override
        public void mouseDragged(MouseEvent evento)
        {
            barrEstado.setText(String.format("Se arrastro en [%d, %d]", evento.getX(), evento.getY()));
        }

        @Override
        public void mouseMoved(MouseEvent evento)
        {
            barrEstado.setText(String.format("Se movio en [%d, %d]", evento.getX(), evento.getY()));
        }
    }

}