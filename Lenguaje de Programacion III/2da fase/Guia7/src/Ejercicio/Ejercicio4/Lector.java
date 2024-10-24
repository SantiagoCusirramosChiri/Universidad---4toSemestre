package Ejercicio.Ejercicio4;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lector {
    public static void main(String[] args) {
        int lineas = 0;
        int palabras = 0;
        int letras = 0;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo : ");
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection != JFileChooser.APPROVE_OPTION) {
            System.out.println("No se seleccionó ningún archivo.");
            return;
        }

        File file = fileChooser.getSelectedFile();

        String palabraFrecuente = null;
        int maxFrecuencia = 0;

        String ultimaPalabra = null;
        int contFrecuencia = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineas++;
                letras += line.length();

                String[] palabrasEnLinea = line.split("\\W");

                for (String p : palabrasEnLinea) {
                    if (!p.isEmpty()) {
                        palabras++;

                        if (p.equals(ultimaPalabra)) {
                            contFrecuencia++;
                        }

                        else {

                            if (contFrecuencia > maxFrecuencia) {
                                maxFrecuencia = contFrecuencia;
                                palabraFrecuente = ultimaPalabra;
                            }

                            ultimaPalabra = p;
                            contFrecuencia = 1;
                        }
                    }
                }
            }

            if (contFrecuencia > maxFrecuencia) {
                maxFrecuencia = contFrecuencia;
                palabraFrecuente = ultimaPalabra;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        System.out.println("Total de líneas: " + lineas);
        System.out.println("Total de palabras: " + palabras);
        System.out.println("Total de letras: " + letras);
        System.out.println("Palabra más frecuente: " + palabraFrecuente + " (frecuencia: " + maxFrecuencia + ")");
    }
}
