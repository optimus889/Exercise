package class02;

import java.util.Scanner;

public class TriangleDemo extends ShapePainting{
    Scanner sc = new Scanner(System.in);
    @Override
    public void draw() {
        System.out.println("请输入要打印的行数：");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
