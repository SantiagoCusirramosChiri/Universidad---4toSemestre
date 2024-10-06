package Actividades.Main;

import Actividades.BankManagement.*;
import Actividades.Exception.BalanceNonZero;
import Actividades.Exception.CreditLimit;
import Actividades.Exception.InsufficientBalance;

import javax.security.auth.login.AccountNotFoundException;
import java.io.FileNotFoundException;


public class main {
    public static void main(String[] args) throws InsufficientBalance, AccountNotFoundException, BalanceNonZero, CreditLimit {
        AccountCredit Juano = new AccountCredit(123456, "Juan", 100, 5000);
        AccountCredit Pedro = new AccountCredit(765432, "Pedro", 500, 5000);
        AccountCredit Dalia = new AccountCredit(456789, "Dalia", 500, 5000);
        AccountCredit Italo = new AccountCredit(456789, "Italo", 500, 5000);
        AccountCredit santi = new AccountCredit(456789, "santi", 500, 5000);

        try {
            santi.bankTransfer(santi, Juano, 900);
        } catch (CreditLimit e) {
            throw new RuntimeException(e);
        }

        System.out.println(Juano.getBalance());
        System.out.println(santi.getBalance());

        Juano.closeBankAccount(santi);

        try {
            Juano.bankTransfer(Italo, Dalia, 1000);
        } catch (CreditLimit e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("cuenta1.getBalance()");
        }

        Italo.bankTransfer(Dalia, Pedro, 300);

        System.out.println(Pedro.getBalance());

        try {
            Italo.ReportReadTransaction();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}