package Actividades.Exception;

import Actividades.BankManagement.AccountCredit;
import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public class AccountNotFound extends Exception {
    public AccountNotFound() {
        super();
    }

    public void AccountNotFoundException(List<AccountCredit> account, AccountCredit destinationAccount) throws AccountNotFoundException {
        if (account.contains(destinationAccount)) {
            throw new AccountNotFoundException("La cuenta no existe");
        }
    }
}
