package Actividades.Exception;

import Actividades.BankManagement.AccountCredit;

public class BalanceNonZero extends Exception {
    public BalanceNonZero() {
        super();
    }

    public void BalanceNonZeroException(AccountCredit verifyAccount) throws BalanceNonZero {
        if (verifyAccount.getBalance() > 0.0) {
            throw new IllegalArgumentException("El saldo de la cuenta no es 0 ");
        }
    }
}
