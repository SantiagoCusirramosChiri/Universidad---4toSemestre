package Guia11.Actividad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//  Observer
interface Observer {
    void update(String message);
}

class UserObserver implements Observer {
    private String name;
    public UserObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("El usuario " + name + " recibio este correo:\n" + message);
    }

    public String getName() {
        return name;
    }
}

class ActionObserver {
    private List<Observer> observers = new ArrayList<>();

    public void addUser(Observer observer) {
        observers.add(observer);
    }

    public void removeUser(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }
}

// Strategy
interface MessageStrategy {
    String applyMessageChange(String message);
}

class NewUniversityEntrant implements MessageStrategy {
    @Override
    public String applyMessageChange(String message) {
        return message + "\n¡Bienvenido al campus! Estamos emocionados de tenerte con nosotros.";
    }
}

class BackToUniversityStudent implements MessageStrategy {
    @Override
    public String applyMessageChange(String message) {
        return message + "\n¡Bienvenido de vuelta! Estamos contentos de verte regresar.";
    }
}

class BackToUniversityTeacher implements MessageStrategy {
    @Override
    public String applyMessageChange(String message) {
        return message + "\n¡Saludos! Gracias por seguir con nosotros este semestre.";
    }
}

class MessageToUniversity {
    private MessageStrategy messageStrategy;

    public void setMessageStrategy(MessageStrategy messageStrategy) {
        this.messageStrategy = messageStrategy;
    }

    public String generateMessage(String message) {
        return messageStrategy.applyMessageChange(message);
    }
}

// Command
interface Command {
    void execute();
}

class SendMessageCommand implements Command {
    private ActionObserver actionObserver;
    private String message;

    public SendMessageCommand(ActionObserver actionObserver, String message) {
        this.actionObserver = actionObserver;
        this.message = message;
    }

    @Override
    public void execute() {
        actionObserver.notifyObservers(message);
    }
}

class CommandInvoker {
    private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void executeCommands() {
        for (Command command : commandList) {
            command.execute();
        }
    }
}

class Main {
    public static void main(String[] args) {

        MessageToUniversity messageToUniversity = new MessageToUniversity();
        ActionObserver actionObserver = new ActionObserver();
        CommandInvoker invoker = new CommandInvoker();

        UserObserver user1 = new UserObserver("user1");
        UserObserver user2 = new UserObserver("user2");
        actionObserver.addUser(user1);
        actionObserver.addUser(user2);

        // mensaje base
        HashMap<Integer, String> mensaje = new HashMap<>();
        mensaje.put(1, "¡Bienvenidos a UCSM!\n" +
                "Nos complace enormemente tenerlos como parte de nuestra comunidad académica.");

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (true) {
            System.out.println("\n OPCIONES ADMIN");
            System.out.println("1. Establecer estrategia de mensaje");
            System.out.println("2. Enviar mensaje a los usuarios");
            System.out.println("3. Agregar usuario observador");
            System.out.println("4. Eliminar usuario observador");
            System.out.println("5. Salir");
            System.out.print("Seleccione: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese una opcion valida.");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.println("\nSeleccione una estrategia para el mensaje:");
                    System.out.println("1. Nuevo estudiante");
                    System.out.println("2. Estudiante de vuelta");
                    System.out.println("3. Profesor de vuelta");
                    System.out.print("Ingrese su opcion: ");
                    int strategyOption = Integer.parseInt(scanner.nextLine());
                    switch (strategyOption) {
                        case 1:
                            messageToUniversity.setMessageStrategy(new NewUniversityEntrant());
                            System.out.println("Estrategia establecida: Nuevo estudiante");
                            break;
                        case 2:
                            messageToUniversity.setMessageStrategy(new BackToUniversityStudent());
                            System.out.println("Estrategia establecida: Estudiante de vuelta");
                            break;
                        case 3:
                            messageToUniversity.setMessageStrategy(new BackToUniversityTeacher());
                            System.out.println("Estrategia establecida: Profesor de vuelta");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                    break;

                case 2:
                    // Aplicar la estrategia
                    String finalMessage = messageToUniversity.generateMessage(mensaje.get(1));
                    Command sendMessageCommand = new SendMessageCommand(actionObserver, finalMessage);
                    invoker.addCommand(sendMessageCommand);
                    invoker.executeCommands();
                    break;

                case 3:
                    // Agregar a un observador
                    System.out.print("Ingrese el nombre del nuevo observador: ");
                    String newUserName = scanner.nextLine();
                    UserObserver newUser = new UserObserver(newUserName);
                    actionObserver.addUser(newUser);
                    System.out.println("Nuevo observador agregado: " + newUserName);
                    break;

                case 4:
                    System.out.print("Ingrese el nombre del observador a eliminar: ");
                    String removeUserName = scanner.nextLine();
                    boolean found = false;
                    for (Observer observer : actionObserver.getObservers()) {
                        if (((UserObserver) observer).getName().equals(removeUserName)) {
                            actionObserver.removeUser(observer);
                            System.out.println("Observador eliminado: " + removeUserName);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Observador no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("¡Gracias por usar el sistema!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}