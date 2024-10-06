package ACT4;

public class Eje4 {
    public static void main(String[] args) {
        System.out.println("Bienvenido\n");
        People persona1 = new People("Saul", "Málaga", 2, 200);
        System.out.println(persona1);
    }
}

class People {
    private static int idCounter = 0;
    private int id;
    private String nombre;
    private String apellido;
    private Account cuenta;

    public People(String nombre, String apellido, int numeroCuenta, double saldoInicial) {
        this.id = ++idCounter;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuenta = new Account(numeroCuenta, saldoInicial); // La cuenta es creada internamente
    }

    public int getId() { return id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Detalles de la Persona:\n" +
                "--------------------------\n" +
                "ID: " + id + "\n" +
                "Nombre: " + nombre + " " + apellido + "\n" +
                cuenta.toString() + "\n";
    }
}

class Account {
    private int numero;
    private double saldo;

    public Account(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) {this.saldo = saldo;}

    @Override
    public String toString() {
        return "Detalles de la Cuenta:\n" +
                "--------------------------\n" +
                "Número de Cuenta: " + numero + "\n" +
                "Saldo: S/ " + String.format("%.2f", saldo) + "\n";
    }
}
