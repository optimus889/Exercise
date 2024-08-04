package extra.lab1;
/*
创建一个名为`Student`的类，用来表示高级面向对象编程课程中的学生。
每个学生对象应该包含名字（first name）、姓氏（last name）、电子邮件地址（email address）和小组编号（group number）。
包括一个`toString()`方法，返回学生的字符串表示形式，以及一个`less()`方法，用于根据小组编号比较两个学生的大小。
编写一个测试程序，用于打印和比较`Student`对象。
*/
public class Student {
    private String firstName;  // 学生的名字
    private String lastName;   // 学生的姓氏
    private String emailAddress;  // 学生的电子邮件地址
    private int groupNumber;   // 学生所在的小组编号

    // 构造函数，初始化学生的名字、姓氏、电子邮件地址和小组编号
    public Student(String firstName, String lastName, String emailAddress, int groupNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.groupNumber = groupNumber;
    }

    // 获取学生的电子邮件地址
    public String getEmailAddress() {
        return emailAddress;
    }

    // 获取学生的名字
    public String getFirstName() {
        return firstName;
    }

    // 获取学生的小组编号
    public int getGroupNumber() {
        return groupNumber;
    }

    // 获取学生的姓氏
    public String getLastName() {
        return lastName;
    }

    // 重写toString方法，返回学生的详细信息
    @Override
    public String toString() {
        return "Student{" +
                "emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", groupNumber=" + groupNumber +
                '}';
    }

    // 比较当前学生和另一个学生的小组编号，判断当前学生的小组编号是否小于另一个学生
    public boolean less(Student other) {
        return this.groupNumber < other.groupNumber;
    }
}

// 测试类，用于创建学生对象并测试比较功能
class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student("John", "Smith", "john.smith@gmail.com", 1);
        Student student2 = new Student("Jane", "Smith", "jane.smith@gmail.com", 2);
        Student student3 = new Student("Alice", "Johnson", "alice.johnson@gmail.com", 3);

        // 打印学生信息
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

        // 比较学生的小组编号并输出结果
        System.out.println("Comparing students by group numbers:");
        System.out.println("Is " + student1.getFirstName() + " in a lower group than " + student2.getFirstName() + " ? " + " " + student1.less(student2));
        System.out.println("Is " + student2.getFirstName() + " in a lower group than " + student3.getFirstName() + " ? " + " " + student2.less(student3));
        System.out.println("Is " + student3.getFirstName() + " in a lower group than " + student1.getFirstName() + " ? " + " " + student3.less(student1));
    }
}
