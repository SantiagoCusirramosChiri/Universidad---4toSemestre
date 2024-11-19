package Guia9.Ejercicio;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompraPasaje {
    public static void main(String[] args) {
        CompraPasajeFrame frame = new CompraPasajeFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}

class CompraPasajeFrame extends JFrame {
    private JLabel labelNombre = new JLabel("Name:");
    private JTextField textNombre = new JTextField(20);
    private JLabel labelDocumento = new JLabel("Document:");
    private JTextField textDocumento = new JTextField(20);
    private JLabel labelFecha = new JLabel("Fecha (day/month/year):");
    private JTextField textFecha = new JTextField(10);

    private JLabel labelServicios = new JLabel("Optional services:");
    private JPanel panelServicios = new JPanel();
    private JCheckBox cbAudifonos = new JCheckBox("Headphones");
    private JCheckBox cbManta = new JCheckBox("Blanket");
    private JCheckBox cbRevistas = new JCheckBox("Magazine");

    private JLabel labelPiso = new JLabel("Choose the floor:");
    private JPanel panelPiso = new JPanel();
    private JRadioButton rbPrimerPiso = new JRadioButton("1st");
    private JRadioButton rbSegundoPiso = new JRadioButton("2nd");
    private ButtonGroup grupoPiso = new ButtonGroup();

    private JLabel labelOrigen = new JLabel("Place of Origin:");
    private JComboBox<String> comboOrigen = new JComboBox<>(new String[]{
            "Amazonas", "Ancash", "Apurimac", "Arequipa", "Ayacucho",
            "Cajamarca", "Callao", "Cusco", "Huancavelica", "Huánuco",
            "Ica", "Junin", "La Libertad", "Lambayeque", "Lima", "Loreto",
            "Madre de Dios", "Moquegua", "Pasco", "Piura", "Puno",
            "San Martín", "Tacna", "Tumbes", "Ucayali"
    });

    private JLabel labelDestino = new JLabel("Place of Destination:");
    private JComboBox<String> comboDestino = new JComboBox<>(new String[]{
            "Amazonas", "Ancash", "Apurimac", "Arequipa", "Ayacucho",
            "Cajamarca", "Callao", "Cusco", "Huancavelica", "Huánuco",
            "Ica", "Junin", "La Libertad", "Lambayeque", "Lima", "Loreto",
            "Madre de Dios", "Moquegua", "Pasco", "Piura", "Puno",
            "San Martín", "Tacna", "Tumbes", "Ucayali"
    });

    private JLabel labelCalidad = new JLabel("Quality of Services:");
    private JList<String> listaCalidad = new JList<>(new String[]{"Poor", "Standard", "VIP"});

    private JButton btnReiniciar = new JButton("Reset");
    private JButton btnResumen = new JButton("Show Summary");

    public CompraPasajeFrame() {
        super("Purchase of Tickets - Transport Company");
        setLayout(new GridLayout(11, 2));

        grupoPiso.add(rbPrimerPiso);
        grupoPiso.add(rbSegundoPiso);
        listaCalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        add(labelNombre);
        add(textNombre);

        add(labelDocumento);
        add(textDocumento);

        add(labelFecha);
        add(textFecha);
        add(labelServicios);

        panelServicios.add(cbAudifonos);
        panelServicios.add(cbManta);
        panelServicios.add(cbRevistas);
        add(panelServicios);

        add(labelPiso);
        panelPiso.add(rbPrimerPiso);
        panelPiso.add(rbSegundoPiso);
        add(panelPiso);

        add(labelOrigen);
        add(comboOrigen);

        add(labelDestino);
        add(comboDestino);

        add(labelCalidad);
        add(new JScrollPane(listaCalidad));

        add(btnReiniciar);
        add(btnResumen);

        btnReiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reiniciarCampos();
            }
        });

        btnResumen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarResumen();
            }
        });
    }

    private void reiniciarCampos() {
        textNombre.setText("");
        textDocumento.setText("");
        textFecha.setText("");
        cbAudifonos.setSelected(false);
        cbManta.setSelected(false);
        cbRevistas.setSelected(false);
        grupoPiso.clearSelection();
        comboOrigen.setSelectedIndex(0);
        comboDestino.setSelectedIndex(0);
        listaCalidad.clearSelection();
    }

    private void mostrarResumen() {
        String nombre = textNombre.getText();
        String documento = textDocumento.getText();
        String fecha = textFecha.getText();
        String servicios = "";
        if (cbAudifonos.isSelected()) servicios += "Headphones ";
        if (cbManta.isSelected()) servicios += "Blanket ";
        if (cbRevistas.isSelected()) servicios += "Magazine ";
        String piso = rbPrimerPiso.isSelected() ? "1st" : rbSegundoPiso.isSelected() ? "2nd" : "Without selection";
        String origen = comboOrigen.getSelectedItem().toString();
        String destino = comboDestino.getSelectedItem().toString();
        String calidad = listaCalidad.getSelectedValue() != null ? listaCalidad.getSelectedValue() : "Without selection";

        JOptionPane.showMessageDialog(this,
                "Purchase Summary:\n" +
                        "Name: " + nombre + "\n" +
                        "Document: " + documento + "\n" +
                        "Date: " + fecha + "\n" +
                        "Optional Services: " + servicios + "\n" +
                        "Floor: " + piso + "\n" +
                        "Origin: " + origen + "\n" +
                        "Destination: " + destino + "\n" +
                        "Quality of Service: " + calidad,
                "Purchase Summary", JOptionPane.INFORMATION_MESSAGE);
    }
}