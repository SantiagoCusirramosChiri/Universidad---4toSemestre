package Guia9.MarcoTeorico;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

class AppLabel {
    public static void main(String[] args)
    {
        LabelFrame marcoEtiqueta = new LabelFrame();
        marcoEtiqueta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoEtiqueta.setSize(260, 180);
        marcoEtiqueta.setVisible(true);
    }
}

class LabelFrame extends JFrame{
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JLabel etiqueta3;

    public LabelFrame () {
        super("Prueba de JLabel");
        setLayout(new FlowLayout());

        etiqueta1 = new JLabel("Etiqueta1 con texto");
        etiqueta1.setToolTipText("Esta es Etiqueta1");
        add(etiqueta1);

        Icon draco = new ImageIcon(getClass().getResource("/Guia9/FotosACT/draco.jpeg"));
        etiqueta2 = new JLabel("Etiqueta2 con texto y foto ", draco, SwingConstants.CENTER);
        etiqueta2.setToolTipText("Esta es Etiqueta2");
        add(etiqueta2);

        etiqueta3 = new JLabel();
        etiqueta3.setText("Etiqueta3 con texto e icono, otra vez");
        etiqueta3.setIcon(draco);
        etiqueta3.setHorizontalTextPosition(SwingConstants.CENTER);
        etiqueta3.setVerticalTextPosition(SwingConstants.BOTTOM);

        etiqueta3.setToolTipText("Esta es Etiqueta3");
        add(etiqueta3);

    }

}
