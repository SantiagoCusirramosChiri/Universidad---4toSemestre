package Actividad.Model;

import Actividad.Controlator.ConnectionDB;

public class TableCreator {

    public static void createTable () {
        String teacherTable =
                "CREATE TABLE IF NOT EXISTS teacher(" +
                        "ID CHAR(10) PRIMARY KEY," +
                        "DNI CHAR(8) NOT NULL," +
                        "Name VARCHAR (100) NOT NULL," +
                        "LastName VARCHAR (100) NOT NULL," +
                        "Mail VARCHAR (100) UNIQUE NOT NULL)"
                ;

        String courseTable =
                "CREATE TABLE IF NOT EXISTS course(" +
                        "ID CHAR (7) PRIMARY KEY," +
                        "Course_Name VARCHAR (100) NOT NULL," +
                        "ID_Teacher CHAR(10)," +
                        "FOREIGN KEY (ID_Teacher) REFERENCES Teacher(ID) ON DELETE CASCADE)"
                ;

        String studentTable =
                "CREATE TABLE IF NOT EXISTS student(" +
                        "ID CHAR(10) PRIMARY KEY," +
                        "DNI CHAR(8) NOT NULL," +
                        "Name VARCHAR (100) NOT NULL," +
                        "LastName VARCHAR (100) NOT NULL," +
                        "Mail VARCHAR (100) UNIQUE NOT NULL)"
                ;

        String recordTable =
                "CREATE TABLE IF NOT EXISTS record(" +
                        "ID_Course CHAR(7)," +
                        "ID_Student CHAR(10)," +
                        "FOREIGN KEY (ID_Course) REFERENCES course(ID) ON DELETE CASCADE," +
                        "FOREIGN KEY (ID_Student) REFERENCES student(ID) ON DELETE CASCADE)"
                ;

        String universityTable =
                "CREATE TABLE IF NOT EXISTS university(" +
                        "Facultad VARCHAR(100)," +
                        "Year INT(4)," +
                        "ID_Professional_School CHAR(7))"
                ;

        String registerTable =
                "CREATE TABLE IF NOT EXISTS register (" +
                        "ID_EP CHAR(7)," +
                        "ID_Student CHAR(10)," +
                        "Courses JSON," +
                        "FOREIGN KEY (ID_EP) REFERENCES university(ID_Professional_School) ON DELETE CASCADE," +
                        "FOREIGN KEY (ID_Student) REFERENCES student(ID) ON DELETE CASCADE)"
                ;

        ConnectionDB.connectionTable(teacherTable, courseTable, studentTable, recordTable, universityTable, registerTable);
    }
}
