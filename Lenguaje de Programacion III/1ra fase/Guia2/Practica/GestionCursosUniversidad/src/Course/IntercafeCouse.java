package Course;

import Person.Student;
import Person.Teacher;
import java.util.List;

public interface IntercafeCouse {

    String getCourseName();
    List<Teacher> getTeacher();
    boolean addTeacher(Teacher person);
    List<Student> getStudent();
    boolean addStudent(Student person);

}
