package Actividades;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

class TestFile {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el nombre del archivo o directorio:");

        // crear objeto Path con base en la entrada del usuario
        Path ruta = Paths.get(sc.nextLine());

        if (Files.exists(ruta)) {
            // mostrar información de archivo (o directorio)
            System.out.printf("%s existe%n", ruta.getFileName());
            System.out.printf("¿Es un directorio? %s%n", Files.isDirectory(ruta) ? "Es" : "No es");
            System.out.printf("¿Es una ruta absoluta? %s%n", ruta.isAbsolute() ? "Es" : "No es");
            System.out.printf("Fecha de última modificación: %s%n", Files.getLastModifiedTime(ruta));
            System.out.printf("Tamaño: %s%n", Files.size(ruta));
            System.out.printf("Ruta: %s%n", ruta);
            System.out.printf("Ruta absoluta: %s%n", ruta.toAbsolutePath());

            if (Files.isDirectory(ruta)) {
                System.out.printf("%nContenido del directorio:%n");

                // objeto para iterar en el contenido de un directorio
                DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta);

                for (Path p : flujoDirectorio) {
                    System.out.println(p);
                }
            }
        } else {
            System.out.printf("%s no existe%n", ruta);
        }
    }
}