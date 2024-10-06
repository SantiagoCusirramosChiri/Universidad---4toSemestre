package Ejercicio.Ejer1;

import java.io.IOException;

class ProcesarEntrada {
    private LeerEntrada entrada;

    public ProcesarEntrada(LeerEntrada entrada) {
        this.entrada = entrada;
    }

    public void procesar() throws IOException, ExcepcionVocal , ExcepcionNumero, ExcepcionBlanco, ExcepcionSalida {
        char c = entrada.getChar();

        if (c == 'q') {
            throw new ExcepcionSalida();

        } else if (Character.isDigit(c)) {
            throw new ExcepcionNumero(c);

        } else if (c == ' ') {
            throw new ExcepcionBlanco();

        } else if (esVocal(c)) {
            throw new ExcepcionVocal(c);

        } else {
            System.out.println("Carácter ingresado: " + c);
        }
    }

    private boolean esVocal(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}
