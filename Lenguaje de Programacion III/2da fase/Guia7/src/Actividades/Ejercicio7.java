package Actividades;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

class ACT_07 extends JFrame {
    private final JTextArea areaSalida;

    public ACT_07() throws IOException {
        super("Demo de JFileChooser");
        areaSalida = new JTextArea();
        add(new JScrollPane(areaSalida)); // areaSalida cuenta con controles deslizables
        analizarRuta(); // obtiene el objeto Path del usuario y muestra la información
    }

    public void analizarRuta() throws IOException {
        // crea un objeto Path con la ruta al archivo o directorio seleccionado por el usuario
        Path ruta = obtenerRutaArchivoDirectorio();

        if (ruta != null && Files.exists(ruta)) {
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("Nombre: %s%n", ruta.getFileName()));
            builder.append(String.format("¿Es un directorio?: %s%n", Files.isDirectory(ruta) ? "Sí" : "No"));
            builder.append(String.format("¿Tiene ruta absoluta?: %s%n", ruta.isAbsolute() ? "Sí" : "No"));
            builder.append(String.format("Última modificación: %s%n", Files.getLastModifiedTime(ruta)));
            builder.append(String.format("Tamaño: %s%n", Files.size(ruta)));
            builder.append(String.format("Ruta absoluta: %s%n", ruta.toAbsolutePath()));

            if (Files.isDirectory(ruta)) {
                builder.append(String.format("%nContenido del directorio:%n"));
                // Objeto para iterar a través del contenido de un directorio
                DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta);

                for (Path p : flujoDirectorio) {
                    builder.append(String.format("%s%n", p));
                }
            }

            areaSalida.setText(builder.toString()); // muestra el contenido del objeto String
        } else {
            JOptionPane.showMessageDialog(this, ruta.getFileName() + " no existe.", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private Path obtenerRutaArchivoDirectorio() {
        JFileChooser selectorArchivos = new JFileChooser();
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int resultado = selectorArchivos.showOpenDialog(this);

        // Si el usuario hizo clic en el botón Cancelar en el cuadro de diálogo, regresa
        if (resultado == JFileChooser.CANCEL_OPTION)
            System.exit(1);

        // devuelve objeto Path que representa el archivo seleccionado
        return selectorArchivos.getSelectedFile().toPath();
    }

    public static class PruebaJFileChooser {
        public static void main(String[] args) throws IOException {
            ACT_07 aplicacion = new ACT_07();
            aplicacion.setSize(400, 400);
            aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            aplicacion.setVisible(true);
        }
    }
}