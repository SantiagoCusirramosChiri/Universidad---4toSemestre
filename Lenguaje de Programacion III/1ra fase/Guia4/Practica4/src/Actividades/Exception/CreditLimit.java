package Actividades.Exception;

public class CreditLimit extends Exception {
    public CreditLimit() {
        super();
    }

    public void checkCreditLimit(double credit, double amount) throws CreditLimit {
        if (credit < amount) {
            throw new IllegalArgumentException("Limite de credito excedido");
        }
    }
}



