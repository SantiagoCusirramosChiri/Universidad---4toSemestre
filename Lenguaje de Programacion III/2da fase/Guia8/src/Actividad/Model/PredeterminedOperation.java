package Actividad.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PredeterminedOperation {

    final String dataBase = "jdbc:sqlite:university.db:";
    protected Container pocrud = new Container();

    public void addTeacher() {
        String[] teachers = pocrud.teachers;
        String sql = "INSERT INTO teacher(ID, DNI, Name, LastName, Mail) VALUES ";

        try (Connection conn = DriverManager.getConnection(dataBase); Statement stmt = conn.createStatement()) {
            for (String i : teachers) {
                stmt.executeUpdate(sql + i);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addCourses() {
        String[] courses = pocrud.courses;
        String sql = "INSERT INTO course(ID, Course_Name,ID_Teacher) VALUES ";

        try (Connection conn = DriverManager.getConnection(dataBase); Statement stmt = conn.createStatement()) {
            for (String i : courses) {
                stmt.executeUpdate(sql + i);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addStudent() {
        String[] students = pocrud.students;
        String sql = "INSERT INTO student(ID, DNI, Name, LastName, Mail) VALUES ";

        try (Connection conn = DriverManager.getConnection(dataBase); Statement stmt = conn.createStatement()) {
            for (String i : students) {
                stmt.executeUpdate(sql + i);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addRecords() {
        String[] records = pocrud.records;
        String sql = "INSERT INTO Pagos(ID_Course, ID_Student) VALUES ";

        try (Connection conn = DriverManager.getConnection(dataBase); Statement stmt = conn.createStatement()) {
            for (String i : records) {
                stmt.executeUpdate(sql + i);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addUniversities() {
        String[] universities = pocrud.universities;
        String sql = "INSERT INTO Pagos(Facultad, Year, ID_Professional_School) VALUES ";

        try (Connection conn = DriverManager.getConnection(dataBase); Statement stmt = conn.createStatement()) {
            for (String i : universities) {
                stmt.executeUpdate(sql + i);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addRegisters() {
        String[] registers = pocrud.registers;
        String sql = "INSERT INTO Pagos(ID_EP, ID_Student, Courses) VALUES ";

        try (Connection conn = DriverManager.getConnection(dataBase); Statement stmt = conn.createStatement()) {
            for (String i : registers) {
                stmt.executeUpdate(sql + i);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropTable() {
        String[] tablas = {"teacher", "course", "student", "record", "university", "register"};

        try (Connection conn = DriverManager.getConnection(dataBase); Statement stmt = conn.createStatement()) {

            for (String i : tablas) {

                String sql = "DROP TABLE IF EXISTS " + i;
                stmt.executeUpdate(sql);
                System.out.println("Tabla " + i + " ha sido eliminada.");

            }

            TableCreator.createTable();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}