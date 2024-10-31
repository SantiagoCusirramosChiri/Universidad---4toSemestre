package Ejercicio;

public class Main {
    public static void main(String[] args) {

        TableCreator dbManager = new TableCreator();
        dbManager.inicio();

        Menu menu = new Menu();
        menu.mostrarMenu();

    }
}
