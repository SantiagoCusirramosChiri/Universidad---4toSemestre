package Actividades.Report;

import java.io.FileNotFoundException;

abstract class Report {
    static protected String pathName = "transactions.txt";

    void reportTransaction() {}
    void readFile() throws FileNotFoundException {}
}
