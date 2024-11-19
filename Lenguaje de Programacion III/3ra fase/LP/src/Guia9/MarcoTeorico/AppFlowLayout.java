package Guia9.MarcoTeorico;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

class AppFlowLayout{
    public static void main(String[] args)
    {
        LabelFrameP marcoEtiqueta = new LabelFrameP();
        marcoEtiqueta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoEtiqueta.setSize(260, 180);
        marcoEtiqueta.setVisible(true);
    }
}


class LabelFrameP extends JFrame{
    public LabelFrameP() {
        super("label");
        JLabel etiqueta = new JLabel("Etiqueta", JLabel.CENTER);
        add(etiqueta);


//        setTitle("Label");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new FlowLayout());

    }
}
