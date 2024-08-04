package extra.lab2;
/*
设计一个名为 MyPoint 的类来表示具有 x 和 y 坐标的点。
该类包含：
数据字段（实例变量）x 和 y，它们用 getter 表示坐标
方法。
创建一个点 （0.0， 0.0） 的空构造函数。
构造具有指定坐标的点的构造函数。
一个名为 distance 的（实例）方法，返回从此点到另一个点的距离
MyPoint 类型的点。
一种静态方法（函数），也称为 distance，它返回来自两个的距离
MyPoint 对象。
编写一个测试程序，创建三个点 （0.0， 0.0）、（10.25， 20.8） 和 （13.25， 24.8） 和
使用两种距离实现显示它们之间的距离。
请注意调用实例方法和静态方法（函数）之间的区别！
*/

// MyPoint类定义，包括两个私有变量x和y表示点的坐标
public class MyPoint {
    private double x;
    private double y;

    // 获取x坐标的方法
    public double getX() {
        return x;
    }

    // 获取y坐标的方法
    public double getY() {
        return y;
    }

    // 无参数的构造方法，默认坐标为(0.0, 0.0)
    public MyPoint() {
        this(0.0,0.0);
    }

    // 带参数的构造方法，用于设置点的x和y坐标
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // 实例方法，计算当前点到另一点的距离
    public double distance(MyPoint other) {
        return distance(this, other);
    }

    // 静态方法，计算两点之间的距离
    public static double distance(MyPoint p1, MyPoint p2) {
        double dx = p1.getX() - p2.getX();  // 计算x坐标之差
        double dy = p1.getY() - p2.getY();  // 计算y坐标之差
        return Math.sqrt(dx*dx + dy*dy);  // 根据勾股定理计算两点间的距离
    }
}

// 测试类MyPointTest
class MyPointTest{
    public static void main(String[] args) {
        // 创建三个点的实例
        MyPoint p1 = new MyPoint(0.0,0.0);
        MyPoint p2 = new MyPoint(10.25,20.8);
        MyPoint p3 = new MyPoint(13.25,24.8);

        // 使用实例方法计算并打印两点之间的距离
        System.out.println("Using instance method:");
        System.out.println("Distance: " + p1.distance(p2));
        System.out.println("Distance: " + p2.distance(p3));
        System.out.println("Distance: " + p3.distance(p1));

        // 使用静态方法计算并打印两点之间的距离
        System.out.println("Using static method:");
        System.out.println("Distance: " + MyPoint.distance(p1,p2));
        System.out.println("Distance: " + MyPoint.distance(p2,p3));
        System.out.println("Distance: " + MyPoint.distance(p1,p3));
    }
}
