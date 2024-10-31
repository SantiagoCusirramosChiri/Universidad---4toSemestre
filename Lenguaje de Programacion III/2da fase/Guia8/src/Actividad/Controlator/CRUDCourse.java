package Actividad.Controlator;

import java.sql.*;

public class CRUDCourse {

    final String dataBase = "jdbc:sqlite:university.db:";

    void update(String id, String courseName, String idTeacher){

        String sql = "INSERT INTO course(ID, Course_Name,ID_Teacher) VALUES (?,?,?)";

        try (Connection conn = DriverManager.getConnection(dataBase); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, courseName);
            pstmt.setString(3, idTeacher);

            pstmt.executeUpdate();
            System.out.println("The data has been updated");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    void read(){}

    void delete(){}

}
