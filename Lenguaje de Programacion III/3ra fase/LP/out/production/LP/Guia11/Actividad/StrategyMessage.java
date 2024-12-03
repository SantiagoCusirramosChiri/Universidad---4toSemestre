package Guia11.Actividad;

interface MessageStrategy {
    String applyMessageChange(String Message);
}

class NewUniversityEntrant implements MessageStrategy {
    public String applyMessageChange(String Message) {
        return Message;
    }
}

class BackToUniversityStudent implements MessageStrategy {
    public String applyMessageChange(String Message) {
        return Message;
    }
}

class BackToUniversityTeacher implements MessageStrategy {
    public String applyMessageChange(String Message) {
        return Message;
    }
}

class MessageToUniversity {
    private MessageStrategy messageStrategy;

    public void setMessageStrategy(MessageStrategy messageStrategy) {
        this.messageStrategy = messageStrategy;
    }

    public String MessageUniversity(String message) {
        return messageStrategy.applyMessageChange(message);
    }
}


class StrategyExample {
    public static void main(String[] args) {
        MessageToUniversity messageToUniversity = new MessageToUniversity();

        // Estrategia 1
        messageToUniversity.setMessageStrategy(new NewUniversityEntrant());
        System.out.println("Cachimbo: " + messageToUniversity.MessageUniversity("ewewewe"));

        // Estrategia 2
        messageToUniversity.setMessageStrategy(new BackToUniversityStudent());
        System.out.println("Estudiante promedio: " + messageToUniversity.MessageUniversity("ewewewe"));

        // Estrategia 3
        messageToUniversity.setMessageStrategy(new BackToUniversityTeacher());
        System.out.println("Profe: " + messageToUniversity.MessageUniversity("ewewewe"));
    }
}