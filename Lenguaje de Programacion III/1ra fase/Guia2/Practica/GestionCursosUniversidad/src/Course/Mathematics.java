package Course;

import Person.Student;
import Person.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Mathematics extends Course implements IntercafeCouse {

    private String courseName;
    static int QuantityStudents = 0;
    static int QuantityTeachers = 0;
    private List<Student> student;
    private List<Teacher> teacher;

    public Mathematics(String courseName, String courseID){
        super(courseName, courseID);
        this.courseName = courseName;
        this.student = new ArrayList<>();
        this.teacher = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Teacher> getTeacher() {
        return teacher;
    }
    public boolean addTeacher(Teacher person) {
        if (QuantityStudents == TotalityTeachers) {
            System.out.println("Ya no se admiten mas profesores");
            QuantityTeachers++;
            return false;
        }
        if (!teacher.contains(person)) {
            teacher.add(person);
            System.out.println("Registro exitoso");
            return true;
        }
        return false;
    }


    public List<Student> getStudent() {
        return student;
    }
    public boolean addStudent(Student person) {
        if (QuantityStudents == TotalityStudents) {
            System.out.println("Los cupos de este curso se han completado");
            QuantityStudents++;
            return false;
        }
        if (!student.contains(person)) {
            student.add(person);
            System.out.println("Registro exitoso");
            return true;
        }
        return false;
    }
}