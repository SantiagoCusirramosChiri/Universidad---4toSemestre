package Actividades.Report;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReportRead extends Report {

    public void readFile() throws FileNotFoundException {
        int count = 0;
        try (Scanner scan = new Scanner(new File(pathName))){
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
                count += 1;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + pathName);
        }
        System.out.println("Transacciones totales: " + count);
    }
}
