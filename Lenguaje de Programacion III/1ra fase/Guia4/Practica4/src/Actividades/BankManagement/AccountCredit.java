package Actividades.BankManagement;

import Actividades.Exception.CreditLimit;
import javax.security.auth.login.AccountNotFoundException;

public class AccountCredit extends Bank {
    double credit;
    double bankDebt;

    public AccountCredit(int accountNumber, String accountHolder, double balance, double credit) {
        super(accountNumber, accountHolder, balance);
        this.credit = credit;
        this.bankDebt = 0;
    }

    public void balanceWithdrawal (double amount) throws CreditLimit {
        if (amount <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a 0");
        }
        creditLimit.checkCreditLimit(credit, amount);
        this.balance -= amount;
    }

    public void bankTransfer(AccountCredit originAccount, AccountCredit destinationAccount, double _balance) throws CreditLimit, AccountNotFoundException {
        accountNotFound.AccountNotFoundException(account, originAccount);
        accountNotFound.AccountNotFoundException(account, destinationAccount);
        originAccount.balanceWithdrawal(_balance);
        destinationAccount.checkDepositedBalance(_balance);
        reportTransaction.reportTransaction(originAccount, destinationAccount);
        System.out.println("Transaferencia completada");
    }

}
