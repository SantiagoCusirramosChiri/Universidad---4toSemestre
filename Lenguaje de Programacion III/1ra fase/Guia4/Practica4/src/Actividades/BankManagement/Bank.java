package Actividades.BankManagement;
import Actividades.Exception.*;
import Actividades.Report.*;

import javax.security.auth.login.AccountNotFoundException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


class Bank {
    int accountNumber;
    String accountHolder;
    double balance = 0.0;
    protected static List<AccountCredit> account = new ArrayList<>();
    protected InsufficientBalance insufficientBalance;
    protected AccountNotFound accountNotFound;
    protected BalanceNonZero balanceNonZero;
    protected CreditLimit creditLimit;
    protected ReportTransaction reportTransaction;
    protected ReportRead reportRead;


    public Bank(int _accountNumber, String _accountHolder, double _balance) {
        this.accountNumber = _accountNumber;
        this.accountHolder = _accountHolder;
        checkDepositedBalance(_balance);
        this.insufficientBalance = new InsufficientBalance();
        this.accountNotFound = new AccountNotFound();
        this.balanceNonZero = new BalanceNonZero();
        this.creditLimit = new CreditLimit();
        this.reportTransaction = new ReportTransaction();
        this.reportRead = new ReportRead();
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber + " " + accountHolder  +" " + balance + "\n";
    }

    public void ReportReadTransaction() throws FileNotFoundException {
        reportRead.readFile();
    }

    public void checkDepositedBalance(double _balance) {
        if (_balance <= 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.balance += _balance;
    }

    public void closeBankAccount(AccountCredit verifyAccount) throws BalanceNonZero, AccountNotFoundException {
        accountNotFound.AccountNotFoundException(account, verifyAccount);
        balanceNonZero.BalanceNonZeroException(verifyAccount);
        verifyAccount = null;
        System.gc();
        accountNotFound.AccountNotFoundException(account, verifyAccount);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
