package Person;

public class Person {
    protected String Id;
    protected String name;
    protected String lastname;
    protected int age;
    protected String occupation;
    protected String email;

    public Person(String Id, String occupation, String name, String lastname, int age, String email) {
        this.Id = Id;
        this.occupation = occupation;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return Id + " " + occupation + " " + name + " " + lastname + " " + age + " " + email;
    }

    String getOccupation() {
        return occupation;
    }
    String getID() {
        return Id;
    }
}