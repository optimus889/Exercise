package extra.lab2;
/*
Design a class named MyPoint to represent a point with x- and y-coordinates.
The class contains:
The data fields (instance variables) x and y that represent the coordinates with getter
methods.
An empty constructor that creates a point (0.0, 0.0).
A constructor that constructs a point with specified coordinates.
A (instance) method named distance that returns the distance from this point to another
point of the MyPoint type.
A static method (function) also named distance that returns the distance from two
MyPoint objects.
Write a test program that creates the three points (0.0, 0.0), (10.25, 20.8) and (13.25, 24.8) and
displays the distance between them using both distance implementations.
Notice the difference between invoking an instance method and a static method (functions)!
*/
public class MyPoint {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public MyPoint() {
        this(0.0,0.0);
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(MyPoint other) {
        return distance (this, other);
    }
    public static double distance(MyPoint p1, MyPoint p2) {
        double dx = p1.getX () - p2.getX ();
        double dy = p1.getY () - p2.getY ();
        return Math.sqrt(dx*dx + dy*dy);
    }
}

class MyPointTest{
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint (0.0,0.0);
        MyPoint p2 = new MyPoint (10.25,20.8);
        MyPoint p3 = new MyPoint (13.25,24.8);

        System.out.println ("Using instance method:");
        System.out.println ("Distance: " + p1.distance (p2));
        System.out.println ("Distance: " + p2.distance (p3));
        System.out.println ("Distance: " + p3.distance (p1));

        System.out.println ("Using static method:");
        System.out.println ("Distance: " + MyPoint.distance(p1,p2));
        System.out.println ("Distance: " + MyPoint.distance(p2,p3));
        System.out.println ("Distance: " + MyPoint.distance(p1,p3));

    }
}
