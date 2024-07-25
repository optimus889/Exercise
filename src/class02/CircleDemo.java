package class02;

import java.util.Scanner;

public class CircleDemo extends ShapePainting{
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

