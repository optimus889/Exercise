package extra.lab1;
/*
Create a class Student to represent students in an Advanced OOP course.
Each student object should represent a first name, last name, email address, and group number.
Include a toString() method that returns a string representation of a student and a less() method that compares two students by their group numbers.
Write a test program that prints and compares Student objects.
*/
public class Student {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private int groupNumber;

    public Student(String firstName, String lastName, String emailAddress, int groupNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.groupNumber = groupNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", groupNumber=" + groupNumber +
                '}';
    }

    public boolean less(Student other) {
        return this.groupNumber < other.groupNumber;
    }
}

class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student("John", "Smith", "john.smith@gmail.com", 1);
        Student student2 = new Student("Jane", "Smith", "jane.smith@gmail.com", 2);
        Student student3 = new Student("Alice", "Johnson", "alice.johnson@gmail.com", 3);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);


        System.out.println ("Comparing students by group numbers:");
        System.out.println ("Is " + student1.getFirstName() + " in a lower group than " + student2.getFirstName() + " ? " + " " + student1.less(student2));
        System.out.println ("Is " + student2.getFirstName() + " in a lower group than " + student3.getFirstName() + " ? " + " " + student2.less(student3));
        System.out.println ("Is " + student3.getFirstName() + " in a lower group than " + student1.getFirstName() + " ? " + " " + student3.less(student1));
    }
}
