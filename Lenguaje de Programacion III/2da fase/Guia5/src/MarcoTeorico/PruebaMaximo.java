package MarcoTeorico;
public class PruebaMaximo{
    public static < T extends Comparable< T > > T maximo( T x, T y, T z ) {
        T max = x;
        if ( y.compareTo( max ) > 0 )
            max = y;
        if ( z.compareTo( max ) > 0 )
            max = z;
        return max;
    }

    public static void main( String args[] ) {
        System.out.printf( "Maximo de %d, %d y %d es %d\n\n", 3, 4, 5, maximo( 3, 4, 5 ) );

        System.out.printf( "Maximo de %.1f, %.1f y %.1f es %.4f\n\n", 6.6, 8.8, 7.7, maximo( 6.6, 8.8, 7.7 ) );

        System.out.printf( "Maximo de %s, %s y %s es %s\n", "pera", "manzana", "naranja", maximo( "pera", "manzana", "naranja" ) );
    }
}