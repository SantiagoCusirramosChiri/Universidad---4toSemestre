package Course;

import Person.Student;
import Person.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private String courseID;
    private List<Student> student;
    private List<Teacher> teacher;
    static protected int TotalityStudents = 5;
    static protected int TotalityTeachers = 1;

    public Course(String courseName, String courseID) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.student = new ArrayList<>();
        this.teacher = new ArrayList<>();
    }

    String getCourseID() {
        return courseID;
    }
}
