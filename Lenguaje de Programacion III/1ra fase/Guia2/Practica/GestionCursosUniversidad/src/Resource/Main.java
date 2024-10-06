package Resource;

import Course.Cisco;
import Course.Mathematics;
import Course.ProgrammingLanguage;
import Person.Student;
import Person.Teacher;

public class Main {
    public static void main(String[] args) {

        Cisco ciscoCourse = new Cisco("Cisco Networking", "FA98");
        Mathematics mathCourse = new Mathematics("Advanced Mathematics", "MATH101");
        ProgrammingLanguage progCourse = new ProgrammingLanguage("Java Programming", "CS102");


        Student student1 = new Student("DF34", "Student", "Alice", "Smith", 14, "alice@gmail.com");
        Student student2 = new Student("GH56", "Student", "Bob", "Johnson", 19, "bob@gmail.com");
        Student student3 = new Student("JK78", "Student", "Charlie", "Brown", 20, "charlie@gmail.com");

        Teacher teacher1 = new Teacher("AD78", "Teacher", "Jimmy", "Smith", 35, "smith@gmail.com", "Networking");
        Teacher teacher2 = new Teacher("KL89", "Teacher", "Sarah", "Connor", 40, "connor@gmail.com", "Mathematics");
        Teacher teacher3 = new Teacher("MN90", "Teacher", "John", "Doe", 45, "doe@gmail.com", "Programming");

        ciscoCourse.addStudent(student1);
        ciscoCourse.addStudent(student2);
        mathCourse.addStudent(student2);
        mathCourse.addStudent(student3);
        progCourse.addStudent(student1);
        progCourse.addStudent(student3);

        ciscoCourse.addTeacher(teacher1);
        mathCourse.addTeacher(teacher2);
        progCourse.addTeacher(teacher3);

        System.out.println("Información de los Cursos:");
//-----------------------------------------------------------------------------
        System.out.println("\nCurso: " + ciscoCourse.getCourseName());
        for (Teacher teacher : ciscoCourse.getTeacher()) {
            System.out.println("Profesor: " + teacher.toString());
        }
        for (Student student : ciscoCourse.getStudent()) {
            System.out.println("Estudiante: " + student.toString());
        }
//-----------------------------------------------------------------------------
        System.out.println("\nCurso: " + mathCourse.getCourseName());
        for (Teacher teacher : mathCourse.getTeacher()) {
            System.out.println("Profesor: " + teacher.toString());
        }
        for (Student student : mathCourse.getStudent()) {
            System.out.println("Estudiante: " + student.toString());
        }
//-----------------------------------------------------------------------------
        System.out.println("\nCurso: " + progCourse.getCourseName());
        for (Teacher teacher : progCourse.getTeacher()) {
            System.out.println("Profesor: " + teacher.toString());
        }
        for (Student student : progCourse.getStudent()) {
            System.out.println("Estudiante: " + student.toString());
        }
    }
}