package Ejercicio.Ejer6;

import Ejercicio.Ejer6.Exception.ContratoInvalidoException;
import Ejercicio.Ejer6.Exception.DatosInvalidosException;
import Ejercicio.Ejer6.Exception.PagoInvalidoException;
import Ejercicio.Ejer6.Exception.PrecioInferiorException;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear una propiedad
            Propiedad propiedad = new Propiedad("Calle Falsa 123", 150000, 120);
            System.out.println("Propiedad creada: " + propiedad);

            // Crear una transacción inmobiliaria
            TransaccionInmobiliaria transaccion = new TransaccionInmobiliaria("TX001", propiedad, 160000);
            System.out.println("Transacción creada: " + transaccion);

            // Crear un contrato de alquiler
            ContratoAlquiler contrato = new ContratoAlquiler(12, 1000);
            System.out.println("Contrato de alquiler creado: " + contrato);

            // Crear un historial de pagos
            HistorialDePagos pago = new HistorialDePagos(new Date(), 500);
            System.out.println("Pago registrado: " + pago);

        } catch (DatosInvalidosException | PrecioInferiorException | ContratoInvalidoException | PagoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}