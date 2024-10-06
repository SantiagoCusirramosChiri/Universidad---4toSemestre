package ACT3;

public class Eje3 {
    public static void main(String[] args) {
        Motor motor1 = new Motor(2000, 10000);
        Automovil auto1 = new Automovil("W3EWRT", 2, "AUDI", "A5", motor1);
        Automovil auto2 = new Automovil("QRE23F", 2, "AUDI", "A1", new Motor(3000, 12000));
        System.out.println(auto1.toString());
        System.out.println(auto2.toString());
    }
}

class Automovil {
    private String placa;
    private int numPuertas;
    private String marca;
    private String modelo;
    private Motor motor; // Agregamos la relación de agregación

    public Automovil(String placa, int numPuertas, String marca, String modelo, Motor motor) {
        this.placa = placa;
        this.numPuertas = numPuertas;
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor; // Asignamos el motor en el constructor
    }

    // GETTERS Y SETTERS
    public String getPlaca() {return placa;}
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public int getNumeroPuertas() {return numPuertas;}
    public void setNumeroPuertas(int numeroPuertas) {
        this.numPuertas = numPuertas;
    }
    public String getMarca() {return marca;}
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {return modelo;}
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public Motor getMotor() {return motor;}
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "placa='" + placa +
                "\nnumPuertas=" + numPuertas +
                "\nmarca='" + marca +
                "\nmodelo='" + modelo +
                "\nmotor=" + motor.toString();
    }
}

class Motor {
    private int numMotor;
    private int revPorMin;

    public Motor(int numMotor, int revPorMin) {
        this.numMotor = numMotor;
        this.revPorMin = revPorMin;
    }
    // GETTERS AND SETTERS
    public int getNumMotor() {return numMotor;}
    public void setNumMotor(int numMotor) {
        this.numMotor = numMotor;
    }

    public int getRevPorMin() {return revPorMin;}
    public void setRevPorMin(int revPorMin) {
        this.revPorMin = revPorMin;
    }

    @Override
    public String toString() {
        return "numMotor=" + numMotor+
                "\nevPorMin=" + revPorMin;
    }
}