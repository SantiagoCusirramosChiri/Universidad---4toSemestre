package MarcoTeorico;
public class Pila< E > {
    private final int tamanio;
    private int superior;
    private E[] elementos;

    public Pila(){
        this( 10 );
    }

    public Pila( int s ) {
        tamanio = s > 0 ? s : 10;
        superior = -1;
        elementos = ( E[] ) new Object[ tamanio ];
    }

    public void push( E valorAMeter ) {
        if ( superior == tamanio - 1 )
            throw new ExcepcionPilaLlena( String.format("La Pila esta llena, no se puede meter %s", valorAMeter ) );
        elementos[ ++superior ] = valorAMeter;
    }

    public E pop(){
        if ( superior == -1 ) // si la pila está vacía
            throw new ExcepcionPilaVacia( "Pila vacia, no se puede sacar" );
        return elementos[ superior-- ];
    }
}

class ExcepcionPilaLlena extends RuntimeException {
    public ExcepcionPilaLlena(String mensaje) {
        super(mensaje);
    }
}

class ExcepcionPilaVacia extends RuntimeException {
    public ExcepcionPilaVacia(String mensaje) {
        super(mensaje);
    }
}