package Actividad;

public class IgualGenerics {
    public static <T> boolean esIgualA(T a, T b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        return a.equals(b);
    }

    public static void main(String[] args) {
        // Comparación de tipos integrados
        System.out.println("Comparación de enteros: " + IgualGenerics.esIgualA(10, 10)); // true
        System.out.println("Comparación de enteros distintos: " + IgualGenerics.esIgualA(10, 20)); // false

        // Comparación con null
        System.out.println("Comparación de null con null: " + IgualGenerics.esIgualA(null, null)); // true
        System.out.println("Comparación de null con un entero: " + IgualGenerics.esIgualA(null, 10)); // false
        System.out.println("Comparación de un entero con null: " + IgualGenerics.esIgualA(10, null)); // false

        // Comparación de Object
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println("Comparación de objetos distintos: " + IgualGenerics.esIgualA(obj1, obj2)); // false
        System.out.println("Comparación de un objeto consigo mismo: " + IgualGenerics.esIgualA(obj1, obj1)); // true

        // Comparación de Integer
        Integer num1 = 100;
        Integer num2 = 100;
        Integer num3 = 200;
        System.out.println("Comparación de Integer iguales: " + IgualGenerics.esIgualA(num1, num2)); // true
        System.out.println("Comparación de Integer distintos: " + IgualGenerics.esIgualA(num1, num3)); // false

        // Comparación de String
        String str1 = "Hola";
        String str2 = "Hola";
        String str3 = "Bye";
        System.out.println("Comparación de String iguales: " + IgualGenerics.esIgualA(str1, str2)); // true
        System.out.println("Comparación de String distintos: " + IgualGenerics.esIgualA(str1, str3)); // false
    }

}
