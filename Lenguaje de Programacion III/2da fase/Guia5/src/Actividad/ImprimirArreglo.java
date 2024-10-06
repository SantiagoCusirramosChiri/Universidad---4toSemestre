package Actividad;

public class ImprimirArreglo {

    public static < E > void imprimirArreglo( E[] arregloEntrada ) {
        for ( E elemento : arregloEntrada )
            System.out.printf( "%s ", elemento );
        System.out.println();
    }

    public static <E> int imprimirArreglo(E[] arregloEntrada, int indexLower, int indexUpper) throws InvalidSubscriptException {
        if (indexLower < 0 || indexUpper >= arregloEntrada.length || indexUpper < indexLower) {
            throw new InvalidSubscriptException("Índices fuera de rango y/o inválidos.");
        }

        int totalElements = 0;
        for (int i = indexLower; i <= indexUpper; i++) {
            System.out.printf("%s ", arregloEntrada[i]+ "\n");
            totalElements++;
        }

        return totalElements;
    }


    public static void main( String args[] ) throws InvalidSubscriptException {
        Integer[] arregloInteger = { 1, 2, 3, 4, 5, 6 };
        Double[] arregloDouble = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
        Character[] arregloCharacter = { 'H', 'O', 'L', 'A' };

        System.out.println( "El arreglo arregloInteger contiene:" );
        int amount = imprimirArreglo( arregloInteger, 0 , 3 );
        System.out.println( "El arreglo arregloDouble contiene:" + amount);

        System.out.println( "\nEl arreglo arregloDouble contiene:" );
        imprimirArreglo( arregloDouble );

        System.out.println( "\nEl arreglo arregloCharacter contiene:" );
        imprimirArreglo( arregloCharacter );
    }
}

class InvalidSubscriptException extends Exception {
    public InvalidSubscriptException(String message) {
        super(message);
    }
}