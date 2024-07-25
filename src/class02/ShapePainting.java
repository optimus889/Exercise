package class02;

import java.util.Scanner;

public abstract class ShapePainting {
        abstract void draw();
}

class Circle extends ShapePainting{
        Scanner sc = new Scanner(System.in);

        @Override
        public void draw() {
                System.out.println("请输入圆的半径：");

                int r = sc.nextInt();
                for (int y = 0; y <= 2 * r; y += 2) {
                        int x = (int) Math.round(r - Math.sqrt(2*r*y - y*y));
                        for (int i = 0; i <= x; i++) {
                                System.out.print(" ");
                        }
                        System.out.print("*");
                        for (int j = 0; j <= 2 * (r-x); j++) {
                                System.out.print(" ");
                        }
                        System.out.println("*");
                }
        }
}

class Square extends ShapePainting {
        Scanner sc = new Scanner(System.in);

        @Override
        public void draw() {
                System.out.println("请输入一个数字：");
                int x = sc.nextInt();

                for (int i = 0; i < x; i++) {
                        for (int j = 0; j < x; j++) {
                                System.out.print("*");
                        }
                        System.out.println();
                }
        }
}

class demo {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                Circle circle = new Circle();
                Square square = new Square();
                System.out.println("请输入要打印的图形：1.圆形 2.正方形");

                int choice = sc.nextInt();
                switch (choice) {
                        case 1:
                                circle.draw();
                                break;
                        case 2:
                                square.draw();
                                break;
                }
        }
}
