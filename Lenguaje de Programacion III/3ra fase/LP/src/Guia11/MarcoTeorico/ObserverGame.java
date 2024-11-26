package Guia11.MarcoTeorico;

import java.util.ArrayList;
import java.util.List;
//Interfaz del Observador
interface ObserverJ {
    void update(int health);
}
//Sujeto (Jugador)
class Player {
    private int health = 100; // Salud inicial
    private List<ObserverJ> observers = new ArrayList<>(); // Lista de observadores
    // Registrar un observador
    public void addObserver(ObserverJ observer) {
        observers.add(observer);
    }
    // Eliminar un observador
    public void removeObserver(ObserverJ observer) {
        observers.remove(observer);
    }
    // El jugador recibe daño
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0; // Aseguramos que la salud no sea negativa
        }
        System.out.println("Jugador recibe " + damage + " de daño. Salud restante: " + health);
        notifyObservers(); // Notificar a los observadores
    }
    // El jugador se cura
    public void heal(int amount) {
        health += amount;
        if (health > 100) {
            health = 100; // Aseguramos que la salud no exceda 100
        }
        System.out.println("Jugador se cura " + amount + " puntos de salud. Salud restante: " + health);
        notifyObservers(); // Notificar a los observadores
    }
    // Notificar a todos los observadores
    private void notifyObservers() {
        for (ObserverJ observer : observers) {
            observer.update(health); // Notificar a cada observador
        }
    }
}
//Observador (Enemigo)
class Enemy implements ObserverJ {
    private String name;
    public Enemy(String name) {
        this.name = name;
    }
    @Override
    public void update(int health) {
        if (health > 50) {
            System.out.println(name + " está manteniendo una actitud neutral. El jugador tiene " + health + " de salud.");
        } else if (health > 20) {
            System.out.println(name + " se vuelve más agresivo. El jugador tiene " + health + " de salud.");
        } else {
            System.out.println(name + " se acerca peligrosamente al jugador. El jugador tiene solo " + health + " de salud. ¡Ataque inminente!");
        }
    }
}
class HealthBar implements ObserverJ {
    @Override
    public void update(int health) {
// Calculamos el porcentaje de vida
        int healthPercentage = (health * 100) / 100;
        System.out.println("Barra de salud actualizada: " + healthPercentage + "%");
    }
}
//Clase principal para probar el código
class ObserverJuego {
    public static void main(String[] args) {
// Crear el jugador
        Player player = new Player();
// Crear enemigos
        Enemy enemy1 = new Enemy("Enemigo 1");
        Enemy enemy2 = new Enemy("Enemigo 2");
        HealthBar healthBar = new HealthBar();
// Registrar los enemigos como observadores del jugador
        player.addObserver(enemy1);
        player.addObserver(enemy2);
        player.addObserver(healthBar);
// Simulamos el juego: el jugador recibe daño y se cura
        System.out.println("\n--- Jugador recibe daño ---");
        player.takeDamage(30); // El jugador recibe 30 puntos de daño
        System.out.println("\n--- Jugador recibe más daño ---");
        player.takeDamage(40); // El jugador recibe 40 puntos de daño (menos de 50 de vida)
        System.out.println("\n--- Jugador recibe daño crítico ---");
        player.takeDamage(30); // El jugador recibe 30 puntos de daño (menos de 20 de vida)
        System.out.println("\n--- Jugador se cura ---");
        player.heal(50); // El jugador se cura 50 puntos de salud
    }
}
