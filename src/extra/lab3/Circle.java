package extra.lab3;
/*
定义一个名为 ComparableCircle 的类，该类扩展 Circle 并实现 Comparable。
实现 compareTo 方法，以根据面积比较圆。编写测试类
查找 ComparableCircle 对象的两个实例中较大的一个
提示：
1. 定义一个名为 ComparableCircle 的类，该类扩展了 Circle 并实现了 Comparable
接口。您需要实现 compareTo 方法，以根据它们的圆圈来比较它们
半径。
2.在ComparableCircle类中实现compareTo方法，以比较基于圆的
在他们的半径上。您应该比较两个圆的半径，如果
当前圆的半径较大，如果较小，则为负整数，如果它们相等，则为零。
3. 编写一个测试类来验证 ComparableCircle 类的功能。创建两个
ComparableCircle 对象并使用 max 方法比较它们的大小
*/

// Circle类定义一个圆
public class Circle {
    private double radius;  // 圆的半径

    // 无参构造函数，默认半径为1.0
    public Circle() {
        this.radius = 1.0;
    }

    // 带参构造函数，设置圆的半径
    public Circle(double radius) {
        this.radius = radius;
    }

    // 获取圆的半径
    public double getRadius() {
        return radius;
    }

    // 设置圆的半径
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // 计算并返回圆的面积
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // 重写toString方法，返回圆的字符串表示
    @Override
    public String toString() {
        return "Circle[radius=" + radius + "]";
    }
}

// ComparableCircle类继承自Circle并实现Comparable接口，以比较圆的大小
class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    // 无参构造函数，调用父类的无参构造函数
    public ComparableCircle() {
        super();
    }

    // 带参构造函数，设置圆的半径
    public ComparableCircle(double radius) {
        super(radius);
    }

    // 实现compareTo方法，根据面积比较两个圆的大小
    @Override
    public int compareTo(ComparableCircle other) {
        if (this.getArea() > other.getArea()) {
            return 1;  // 当前圆面积大于另一个圆
        } else if (this.getArea() < other.getArea()) {
            return -1;  // 当前圆面积小于另一个圆
        } else {
            return 0;  // 两个圆面积相等
        }
    }

    // 重写toString方法，增加面积信息
    @Override
    public String toString() {
        return "ComparableCircle[radius=" + getRadius() + ", area=" + getArea() + "]";
    }
}

// 测试类，用于创建ComparableCircle对象并比较它们的大小
class ComparableCircleTest{
    public static void main(String[] args) {
        ComparableCircle circle1 = new ComparableCircle(3.0);  // 创建第一个可比较圆
        ComparableCircle circle2 = new ComparableCircle(4.0);  // 创建第二个可比较圆

        // 打印两个圆的信息
        System.out.println("Circle 1: " + circle1);
        System.out.println("Circle 2: " + circle2);

        // 比较两个圆的大小
        int comparisonResult = circle1.compareTo(circle2);
        if (comparisonResult > 0) {
            System.out.println("Circle 1 is larger.");
        } else if (comparisonResult < 0) {
            System.out.println("Circle 2 is larger.");
        } else {
            System.out.println("Both circles are of equal area.");
        }

        // 找出并打印两个圆中较大的一个
        ComparableCircle largerCircle = max(circle1, circle2);
        System.out.println("The larger circle is: " + largerCircle);
    }

    // 辅助方法，用于比较两个圆并返回较大的圆
    public static ComparableCircle max(ComparableCircle c1, ComparableCircle c2) {
        return (c1.compareTo(c2) >= 0) ? c1 : c2;
    }
}