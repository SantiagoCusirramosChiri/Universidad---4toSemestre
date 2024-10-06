package Actividades.Exception;

public class InsufficientBalance extends Exception {
    public InsufficientBalance() {
        super();
    }

    public void checkBalance(double balance, double amount) throws InsufficientBalance {
        if (balance < amount) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }
}