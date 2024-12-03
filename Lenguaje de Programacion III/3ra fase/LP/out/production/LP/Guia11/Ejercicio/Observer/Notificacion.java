package Guia11.Ejercicio.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Sujeto
class Notificacion implements Sujeto{
    private List<Clientes> clientes = new ArrayList<>();
    private Scanner scan;
    private String mensaje;

    public Notificacion(){
        scan= new Scanner(System.in);
    }

    @Override
    public void suscribir(Clientes cliente) {
        clientes.add(cliente);
        System.out.println(cliente.getNombre() + "  se ha suscrito.");
    }

    @Override
    public void desuscribir(Clientes cliente) {
        clientes.remove(cliente);
        System.out.println(cliente.getNombre() + " se ha desuscrito.");
    }

    @Override
    public void notificar() {
        for (Clientes cli : clientes) {
            cli.actualizar(mensaje);
        }
    }
    @Override
        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
            notificar();
        }

        public void SeguirPagina(Clientes clien) {
            boolean validar = false;
            String eleccion;
        
            for (Clientes cli : clientes) {
                if (cli.getNombre().equals(clien.getNombre())) {
                    validar = true;
                    break;
                }
            }
        
            if (validar) {
                System.out.println("¿Desea desuscribirse? yes/no");
                eleccion = scan.nextLine();
                if (eleccion.equalsIgnoreCase("yes")) {
                    desuscribir(clien);
                }
            } else {
                System.out.println("¿Desea suscribirse? yes/no");
                eleccion = scan.nextLine();
                if (eleccion.equalsIgnoreCase("yes")) {
                    suscribir(clien);
                }
            }
        }
}
