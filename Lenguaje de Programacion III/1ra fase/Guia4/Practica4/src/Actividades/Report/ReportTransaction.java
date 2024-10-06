package Actividades.Report;

import Actividades.BankManagement.AccountCredit;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportTransaction extends Report{
    public void reportTransaction(AccountCredit accountHolder, AccountCredit account) {
        try (BufferedWriter writerinformation = new BufferedWriter(new FileWriter(pathName, true))) {
            writerinformation.write(" Origen: " + accountHolder + " Destino: " + account.toString());
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar en el archivo: " + e.getMessage());
        }
    }
}