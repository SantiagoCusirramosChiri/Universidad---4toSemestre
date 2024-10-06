package ACT1;

public class Main {
    public static void main(String[] args) {
        Coche cocheDeportivo = new Coche("Ferrari", 350, 500, 2023, 150000);
        Coche cocheTodoTerreno = new Coche("Land Rover", 200, 300, 2020, 100000);

        cocheDeportivo.descuento();
        cocheTodoTerreno.descuento();

        System.out.println("\n1ro el " + cocheDeportivo.getModelo() + " - Coche Deportivo");
        cocheDeportivo.encender();
        cocheDeportivo.acelerar();
        cocheDeportivo.frenar();
        cocheDeportivo.apagar();

        System.out.println("\n2do el " + cocheTodoTerreno.getModelo() + " - Coche Todo Terreno");
        cocheTodoTerreno.encender();
        cocheTodoTerreno.acelerar();
        cocheTodoTerreno.frenar();
        cocheTodoTerreno.apagar();
    }
}