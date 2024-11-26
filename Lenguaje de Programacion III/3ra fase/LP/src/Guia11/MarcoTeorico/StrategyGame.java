package Guia11.MarcoTeorico;

import java.util.ArrayList;
import java.util.List;
// 1. Estrategia para el comportamiento del enemigo
interface EnemyBehaviorStrategy {
    void behave();
}
// Comportamiento de enemigo cuando la salud del jugador es alta
class NeutralBehavior implements EnemyBehaviorStrategy {
    @Override
    public void behave() {
        System.out.println("El enemigo mantiene una postura neutral.");
    }
}
// Comportamiento de enemigo cuando la salud del jugador es media
class AggressiveBehavior implements EnemyBehaviorStrategy {
    @Override
    public void behave() {
        System.out.println("El enemigo se vuelve más agresivo.");
    }
}
// Comportamiento de enemigo cuando la salud del jugador es baja
class AttackBehavior implements EnemyBehaviorStrategy {
    @Override
    public void behave() {
        System.out.println("El enemigo ataca al jugador inmediatamente.");
    }
}
// 2. Interfaz Observer
interface ObserverBe {
    void update(int health);
}
// 3. Clase Jugador (Sujeto)
class PlayerBe {
    private int health = 100;
    private List<ObserverBe> observers = new ArrayList<>();
    public void addObserver(ObserverBe observer) {
        observers.add(observer);
    }
    public void removeObserver(ObserverBe observer) {
        observers.remove(observer);
    }
    // Cuando el jugador recibe daño
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
        System.out.println("Jugador recibe " + damage + " de daño. Salud restante: " + health);
        notifyObservers();
    }
    // Notificar a los enemigos (observadores) sobre el cambio de salud
    private void notifyObservers() {
        for (ObserverBe observer : observers) {
            observer.update(health);
        }
    }
    // Obtener la salud del jugador
    public int getHealth() {
        return health;
    }
}
// 4. Clase Enemigo (Observador)
class EnemyBe implements ObserverBe {
    private String name;
    private EnemyBehaviorStrategy behaviorStrategy;
    public EnemyBe(String name) {
        this.name = name;
    }
    @Override
    public void update(int health) {
// Cambiar el comportamiento del enemigo basado en la salud del jugador
        if (health > 60) {
            behaviorStrategy = new NeutralBehavior();
        } else if (health > 30) {
            behaviorStrategy = new AggressiveBehavior();
        } else {
            behaviorStrategy = new AttackBehavior();
        }
// Ejecutar el comportamiento
        System.out.println(name + ":");
        behaviorStrategy.behave();
    }
}
// 5. Clase Principal
class ObserverBehavior {
    public static void main(String[] args) {
// Crear el jugador
        PlayerBe player = new PlayerBe();
// Crear enemigos
        EnemyBe enemy1 = new EnemyBe("Enemigo 1");
        EnemyBe enemy2 = new EnemyBe("Enemigo 2");
// Registrar enemigos como observadores
        player.addObserver(enemy1);
        player.addObserver(enemy2);
// Simulación de daño al jugador y cómo reaccionan los enemigos
        System.out.println("\n--- Jugador recibe 20 de daño ---");
        player.takeDamage(20); // La salud del jugador es 80
        System.out.println("\n--- Jugador recibe 30 de daño ---");
        player.takeDamage(30); // La salud del jugador es 50
        System.out.println("\n--- Jugador recibe 30 de daño ---");
        player.takeDamage(30); // La salud del jugador es 20
    }
}