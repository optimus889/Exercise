package class02;

import java.util.Scanner;

public class SquareDemo extends ShapePainting {
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
