package MarcoTeorico;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterExample {

    public static void main(String[] args) {
        String fileName = "texto_printwriter.txt";
        String[] lines = {
                "Primera línea del archivo.",
                "Segunda línea del archivo.",
                "Tercera línea del archivo."
        };

        // creacion del objeto
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (String line : lines) {
                writer.println(line);
            }
            System.out.println("Contenido escrito en el archivo: " + fileName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }
}