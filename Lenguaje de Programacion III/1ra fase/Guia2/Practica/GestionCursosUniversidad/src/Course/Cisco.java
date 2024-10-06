package Course;

import Person.Student;
import Person.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Cisco extends Course implements IntercafeCouse {

    private String courseName;
    static int QuantityStudents = 0;
    static int QuantityTeachers = 0;
    private List<Student> studentCisco;
    private List<Teacher> teacherCisco;

    public Cisco(String courseName, String courseID){
        super(courseName, courseID);
        this.courseName = courseName;
        this.studentCisco = new ArrayList<>();
        this.teacherCisco = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Teacher> getTeacher() {
        return teacherCisco;
    }
    public boolean addTeacher(Teacher person) {
        if (QuantityStudents == TotalityTeachers) {
            System.out.println("Ya no se admiten mas profesores");
            QuantityTeachers++;
            return false;
        }
        if (!teacherCisco.contains(person)) {
            teacherCisco.add(person);
            System.out.println("Registro exitoso");
            return true;
        }
        return false;
    }


    public List<Student> getStudent() {
        return studentCisco;
    }
    public boolean addStudent(Student person) {
        if (QuantityStudents == TotalityStudents) {
            System.out.println("Los cupos de este curso se han completado");
            QuantityStudents++;
            return false;
        }
        if (!studentCisco.contains(person)) {
            studentCisco.add(person);
            System.out.println("Registro exitoso");
            return true;
        }
        return false;
    }
}
