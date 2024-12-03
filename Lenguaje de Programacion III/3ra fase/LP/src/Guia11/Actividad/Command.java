package Guia11.Actividad;

import java.util.Scanner;

interface Command {
    void execute();
}

class Action {
    public void turnOn() {
        System.out.println("La luz esta encendida");
    }
    public void turnOff() {
        System.out.println("La luz esta apagada");
    }
    public void changeCanal() {
        System.out.println("El TV ha cambiado de canal");
    }
    public void lowerVolumen() {
        System.out.println("Subiendo volumen");
    }
    public void incraseVolumen() {
        System.out.println("Bajando volumen");
    }
}


class TurnOnLightCommand implements Command {
    private Action light;
    public TurnOnLightCommand(Action light) {
        this.light = light;
    }
    public void execute() {
        light.turnOn();
    }
}


class TurnOffLightCommand implements Command {
    private Action light;
    public TurnOffLightCommand(Action light) {
        this.light = light;
    }
    public void execute() {
        light.turnOff();
    }
}

class ChangeCanalCommand implements Command {
    private Action canal;
    public ChangeCanalCommand(Action canal) {
        this.canal = canal;
    }
    public void execute() {
        canal.changeCanal();
    }
}

class LowerVolumeCommand implements Command{
    private Action volume;
    public LowerVolumeCommand(Action volume) {
        this.volume = volume;
    }
    public void execute() {
        volume.lowerVolumen();
    }
}

class IncreaseVolumeCommand implements Command{
    private Action volume;
    public IncreaseVolumeCommand(Action volume) {
        this.volume = volume;
    }
    public void execute() {
        volume.incraseVolumen();
    }
}

class RemoteControl {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButton() {
        command.execute();
    }
}


class CommandExample {
    public static void main(String[] args) {
        Action action = new Action();

        Command turnOn = new TurnOnLightCommand(action);
        Command turnOff = new TurnOffLightCommand(action);
        Command changeCanal = new ChangeCanalCommand(action);
        Command lowerVolume = new LowerVolumeCommand(action);
        Command increaseVolume = new IncreaseVolumeCommand(action);

        RemoteControl remote = new RemoteControl();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Menú TV ---");
            System.out.println("1. Encender la luz");
            System.out.println("2. Apagar la luz");
            System.out.println("3. Cambiar canal");
            System.out.println("4. Bajar volumen");
            System.out.println("5. Subir volumen");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opcion: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    remote.setCommand(turnOn);
                    break;
                case 2:
                    remote.setCommand(turnOff);
                    break;
                case 3:
                    remote.setCommand(changeCanal);
                    break;
                case 4:
                    remote.setCommand(lowerVolume);
                    break;
                case 5:
                    remote.setCommand(increaseVolume);
                    break;
                case 6:
                    exit = true;
                    continue;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    continue;
            }

            remote.pressButton();
        }

        System.out.println("¡Hasta luego!");
        scanner.close();
    }
}