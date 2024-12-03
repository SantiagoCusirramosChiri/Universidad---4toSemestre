package Guia11.MarcoTeorico;

//Command Interface
interface Command {
    void execute();
}
//Receiver
class Light {
    public void turnOn() {
        System.out.println("La luz está encendida");
    }
    public void turnOff() {
        System.out.println("La luz está apagada");
    }
}
//Concrete Commands
class TurnOnLightCommand implements Command {
    private Light light;
    public TurnOnLightCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.turnOn();
    }
}
class TurnOffLightCommand implements Command {
    private Light light;
    public TurnOffLightCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.turnOff();
    }
}
//Invoker
class RemoteControl {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButton() {
        command.execute();
    }
}
//Main
class CommandExample {
    public static void main(String[] args) {
        Light light = new Light();
        Command turnOn = new TurnOnLightCommand(light);
        Command turnOff = new TurnOffLightCommand(light);
        RemoteControl remote = new RemoteControl();
//Turn light on
        remote.setCommand(turnOn);
        remote.pressButton();
//Turn light off
        remote.setCommand(turnOff);
        remote.pressButton();
    }
}
