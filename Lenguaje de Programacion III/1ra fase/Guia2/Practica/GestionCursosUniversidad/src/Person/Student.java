package Person;
import java.io.Serializable;

public class Student extends Person implements Serializable, InterfacePerson {

    private static final long serialVersionUID = 1L;
    public Student(String studentID, String occupation, String name, String lastName, int age, String email) {
        super(studentID, occupation, name, lastName, age, email);
    }

    @Override
    public void showInfo() {
        System.out.println(super.toString());
    }

    @Override
    public String toString() {
        return super.toString();
    }

}