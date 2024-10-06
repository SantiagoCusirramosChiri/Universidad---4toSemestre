package Person;
import java.io.Serializable;

public class Teacher extends Person implements Serializable, InterfacePerson {

    private static final long serialVersionUID = 1L;
    private String courseSubject;

    public Teacher(String teacherID, String occupation, String name, String lastName, int age, String email, String courseSubject) {
        super(teacherID, occupation, name, lastName, age, email);
        this.courseSubject = courseSubject;
    }

    @Override
    public void showInfo() {
        System.out.println(super.toString());
    }

    @Override
    public String toString() {
        return super.toString() + " " + courseSubject;
    }

    String getCourseSubject() {
        return courseSubject;
    }

}
