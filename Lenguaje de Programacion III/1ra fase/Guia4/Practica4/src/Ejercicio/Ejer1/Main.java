package Ejercicio.Ejer1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        LeerEntrada entrada = new LeerEntrada(System.in);
        ProcesarEntrada procesador = new ProcesarEntrada(entrada);
        char c = ' ';

        System.out.println("Programa interactivo de lectura de caracteres.");
        System.out.println("Introduce caracteres (ingresa 'q' para salir):");

        while (true) {
            try {
                procesador.procesar();

            } catch (ExcepcionVocal e) {
                System.out.println(e.getMessage());

            } catch (ExcepcionNumero e) {
                System.out.println(e.getMessage());

            } catch (ExcepcionBlanco e) {
                System.out.println(e.getMessage());

            } catch (ExcepcionSalida e) {
                System.out.println(e.getMessage());
                break;

            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
            }
        }

        System.out.println("Programa finalizado.");
    }
}
