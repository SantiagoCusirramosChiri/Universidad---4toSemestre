package Actividad.Controlator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {

    public static void connectionTable(String teacherTable, String courseTable, String studentTable,
                                           String recordTable, String universityTable, String registerTable) {
        final String dataBase = "jdbc:sqlite:university.db:";


        try (Connection conn = DriverManager.getConnection(dataBase); Statement stmt = conn.createStatement()) {
            stmt.execute(teacherTable);
            stmt.execute(courseTable);
            stmt.execute(studentTable);
            stmt.execute(recordTable);
            stmt.execute(universityTable);
            stmt.execute(registerTable);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
