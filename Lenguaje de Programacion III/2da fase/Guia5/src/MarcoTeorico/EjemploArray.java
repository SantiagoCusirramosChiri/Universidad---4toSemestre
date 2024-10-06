package MarcoTeorico;
import java.util.ArrayList;

public class EjemploArray {
    public static void main(String[] args) {

        ArrayList<String> frutas = new ArrayList<>();

        frutas.add("Manzana");
        frutas.add("Banana");
        frutas.add("Naranja");

        System.out.println(frutas.get(1)); // Imprime "Banana"

        for (String fruta : frutas) {
            System.out.println(fruta);
        }
    }
}