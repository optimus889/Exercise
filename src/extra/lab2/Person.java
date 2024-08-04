package extra.lab2;

import java.time.LocalDate;

/*
Design a class named Person and its two subclasses named Student and Employee.
Make Faculty and Staff subclasses of Employee.
A person has a name, address, phone number, and e-mail address.
A student has a class status (freshman, sophomore, junior, or senior).
Define the status as a constant.
An employee has an office, salary, and date hired.
Use the LocalDate class to create an object for date hired.
A faculty member has office hours and a rank.
A staff member has a title.
Add a constructor that only takes name to each class (you may add other constructors).
Override the toString method in each class to display the class name and the person’s name.
What should the access modifier of name in Person be?
Write a test program that creates a Person, Student, Employee, Faculty, and Staff
objects in an array, and invokes their toString() methods using polymorphism.
*/
public class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    public Person(String name){
        this.name = name;
    }
    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" + "name= " + getName() + '\'' + "}";
    }
}

class Student extends Person {
    public static final String FRESHMAN = "Freshman";
    public static final String SOPHOMORE = "Sophomore";
    public static final String JUNIOR = "Junior";
    public static final String SENIOR = "Senior";

    private String status;

    public Student(String name){
        super (name);
    }

    public Student(String name, String status){
        super(name);
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" + "name= " + getName()+ '\'' + "}";
    }
}

class Employee extends Person {
    private String office;
    private double salary;
    private LocalDate dataHired;

    public Employee(String name) {
        super (name);
    }

    public Employee(String name, String office, double salary, LocalDate dataHired) {
        super (name);
        this.office = office;
        this.salary = salary;
        this.dataHired = dataHired;
    }



    @Override
    public String toString() {
        return "Employee{" + "name= " + getName()+ '\'' + "}";
    }
}

class Faculty extends Employee {
    private String officeHours;
    private String rank;

    public Faculty(String name) {
        super (name);
    }
    public Faculty(String name, String office, double salary, LocalDate dataHired, String officeHours,String rank) {
        super (name,office,salary,dataHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Faculty{" + "name= " + getName()+ '\'' + "}";
    }
}

class Staff extends Employee {
    private String title;

    public Staff(String name, String office, double salary, LocalDate dataHired, String title) {
        super (name,office,salary,dataHired);
        this.title = title;
    }

    @Override
    public String toString() {
        return "Staff{" + "name= " + getName()+ '\'' + "}";
    }
}

class PersonTest{
    public static void main(String[] args) {
        Person person = new Person ("John Doe");
        Student student = new Student("Jane Smith", Student.SOPHOMORE);
        Employee employee = new Employee ("Mark Johnson", "office 101", 50000, LocalDate.of (2020,1,15));
        Faculty faculty = new Faculty("Emily Davis", "office 202", 70000, LocalDate.of (2018,5,10),"9am-5pm","professor");
        Staff staff = new Staff ("Michael Brown","office 303", 45000, LocalDate.of (2019,8,20),"Manager");

        Person[] people = {person,student,employee,faculty,staff};

        for (Person p : people) {
            System.out.println (p);
        }
    }
}
