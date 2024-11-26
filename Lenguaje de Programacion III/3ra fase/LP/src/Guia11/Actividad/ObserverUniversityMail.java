package Guia11.Actividad;

// sujeto ' observador ' acciones


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

interface Observer {
    void update(String message);
}

class UserObserver implements Observer {
    private String name;
    public UserObserver(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println("El usuario " + name + " recibio este correo:\n" + message);
    }
}

class ActionObserver{
    private List<Observer> user = new ArrayList<Observer>();

    public void addUser(Observer userObserver) {
        user.add(userObserver);
    }

    public void removeUser(Observer user) {
        this.user.remove(user);
    }

    public void notifyObservers(String message) {
        for (Observer user : user) {
            user.update(message);
        }
    }
}

class ObserverUniversityMail {
    public static void main(String[] args) {
        HashMap<Integer,String> mensaje = new HashMap<>();

        mensaje.put(1,
                "¡Bienvenidos a UCSM!\n" +
                        "Nos complace enormemente tenerlos como parte de nuestra comunidad académica. Este es el comienzo de una nueva etapa llena de aprendizajes, desafíos y oportunidades. " +
                        "Estamos aquí para apoyarlos en cada paso de su camino y para ayudarles a alcanzar sus metas.\n\n" +
                        "¡Les deseamos mucho éxito en esta emocionante aventura!"
        );


        ActionObserver subjet = new ActionObserver();

        UserObserver user1 = new UserObserver("user1");
        UserObserver user2 = new UserObserver("user2");

        subjet.addUser(user1);
        subjet.addUser(user2);

        subjet.notifyObservers(mensaje.get(1));
    }
}
