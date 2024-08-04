package extra.lab2;
/*
设计一个名为 Person 的类及其两个名为 Student 和 Employee 的子类。
使教职员工成为员工的子类。
某人具有姓名、地址、电话号码和电子邮件地址。
学生具有班级状态（大一、大二、大三或大四）。
将状态定义为常量。
员工有办公室、薪水和雇用日期。
使用 LocalDate 类为雇用日期创建对象。
教职员工有办公时间和等级。
工作人员有头衔。
添加一个只对每个类命名的构造函数（您可以添加其他构造函数）。
重写每个类中的 toString 方法以显示类名和人员姓名。
Person 中 name 的访问修饰符应该是什么？
编写一个测试程序，用于创建人员、学生、员工、教职员工
数组中的对象，并使用多态性调用它们的 toString（） 方法。
*/
import java.time.LocalDate;  // 导入LocalDate类，用于处理日期

// 基础类Person，代表普通人
public class Person {
    private String name;  // 人的名字
    private String address;  // 地址
    private String phoneNumber;  // 电话号码
    private String emailAddress;  // 电子邮件地址

    // 构造函数，初始化只有名字
    public Person(String name){
        this.name = name;
    }

    // 构造函数，初始化所有属性
    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    // 获取名字
    public String getName() {
        return name;
    }

    // 获取地址
    public String getAddress() {
        return address;
    }

    // 获取电子邮件地址
    public String getEmailAddress() {
        return emailAddress;
    }

    // 获取电话号码
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // 重写toString方法，以字符串形式返回人的名字
    @Override
    public String toString() {
        return "Person{" + "name= " + getName() + '\'' + "}";
    }
}

// 继承自Person的Student类，代表学生
class Student extends Person {
    // 静态常量定义学生的年级
    public static final String FRESHMAN = "Freshman";
    public static final String SOPHOMORE = "Sophomore";
    public static final String JUNIOR = "Junior";
    public static final String SENIOR = "Senior";

    private String status;  // 学生的状态（年级）

    // 构造函数，只需名字和状态
    public Student(String name, String status){
        super(name);
        this.status = status;
    }

    // 重写toString方法，以字符串形式返回学生的名字
    @Override
    public String toString() {
        return "Student{" + "name= " + getName() + '\'' + "}";
    }
}

// 继承自Person的Employee类，代表雇员
class Employee extends Person {
    private String office;  // 办公室位置
    private double salary;  // 薪资
    private LocalDate dataHired;  // 雇佣日期

    // 构造函数，初始化基础信息
    public Employee(String name, String office, double salary, LocalDate dataHired) {
        super(name);
        this.office = office;
        this.salary = salary;
        this.dataHired = dataHired;
    }

    // 重写toString方法，以字符串形式返回雇员的名字
    @Override
    public String toString() {
        return "Employee{" + "name= " + getName() + '\'' + "}";
    }
}

// 继承自Employee的Faculty类，代表教职员工
class Faculty extends Employee {
    private String officeHours;  // 办公时间
    private String rank;  // 职称

    // 构造函数，初始化所有信息
    public Faculty(String name, String office, double salary, LocalDate dataHired, String officeHours, String rank) {
        super(name, office, salary, dataHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    // 重写toString方法，以字符串形式返回教职员工的名字
    @Override
    public String toString() {
        return "Faculty{" + "name= " + getName() + '\'' + "}";
    }
}

// 继承自Employee的Staff类，代表行政人员
class Staff extends Employee {
    private String title;  // 职位

    // 构造函数，初始化所有信息
    public Staff(String name, String office, double salary, LocalDate dataHired, String title) {
        super(name, office, salary, dataHired);
        this.title = title;
    }

    // 重写toString方法，以字符串形式返回行政人员的名字
    @Override
    public String toString() {
        return "Staff{" + "name= " + getName() + '\'' + "}";
    }
}

// 测试类PersonTest，用于创建并显示不同种类的人物实例
class PersonTest{
    public static void main(String[] args) {
        Person person = new Person("John Doe");  // 创建Person实例
        Student student = new Student("Jane Smith", Student.SOPHOMORE);  // 创建Student实例
        Employee employee = new Employee("Mark Johnson", "office 101", 50000, LocalDate.of(2020, 1, 15));  // 创建Employee实例
        Faculty faculty = new Faculty("Emily Davis", "office 202", 70000, LocalDate.of(2018, 5, 10), "9am-5pm", "professor");  // 创建Faculty实例
        Staff staff = new Staff("Michael Brown", "office 303", 45000, LocalDate.of(2019, 8, 20), "Manager");  // 创建Staff实例

        Person[] people = {person, student, employee, faculty, staff};  // 创建Person数组，包含各种实例

        for (Person p : people) {
            System.out.println(p);  // 遍历并打印所有人物实例
        }
    }
}
