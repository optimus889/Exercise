package class02;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircleDemo circle = new CircleDemo();
        SquareDemo square = new SquareDemo();
        TriangleDemo triangle = new TriangleDemo();
        System.out.println("请输入要打印的图形：1.圆形 2.正方形 3.三角形");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                circle.draw();
                break;
            case 2:
                square.draw();
                break;
            case 3:
                triangle.draw();
                break;
        }
    }
}
