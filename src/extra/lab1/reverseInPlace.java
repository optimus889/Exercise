package extra.lab1;
/*
在课堂上，我们学习了一种反转整数数组的方法，该方法通过将数组复制到一个新数组中并返回该数组来实现反转。
编写一个名为 `reverseInPlace` 的方法，该方法可以原地反转传入参数中的双精度浮点数数组，并且不返回任何内容。
之后，编写一个测试程序，提示用户输入任意数字，调用该方法反转这些数字，并显示数组。
你的测试程序应该首先提示用户输入数组的大小。
对各种输入数组测试该方法。
*/

// 导入Java的扫描器类，用于读取用户输入
import java.util.Scanner;

public class reverseInPlace {
    // 定义一个方法reverseInPlace，用于原地反转传入的double数组，不返回任何值
    public static void reverseInPlace(double[] arr) {
        int min = 0;  // 设置一个指针指向数组的起始位置
        int max = arr.length - 1;  // 设置一个指针指向数组的末尾位置
        while (min < max) {  // 当起始位置小于末尾位置时，执行循环
            double temp = arr[min];  // 交换两个指针所指元素的值
            arr[min] = arr[max];
            arr[max] = temp;

            min++;  // 将起始位置指针向后移
            max--;  // 将末尾位置指针向前移
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // 创建一个扫描器对象来读取输入
        System.out.println("Enter the size of the array: ");  // 提示用户输入数组的大小
        int size = sc.nextInt();  // 读取数组的大小
        double[] arr = new double[size];  // 根据用户输入的大小创建一个double类型的数组
        System.out.println("Enter " + size + " elements: ");  // 提示用户输入数组的元素
        for (int i = 0; i < size; i++) {  // 循环读取每个元素的值
            arr[i] = sc.nextDouble();  // 将用户输入的值存储在数组中
        }
        reverseInPlace(arr);  // 调用reverseInPlace方法反转数组
        System.out.println("The reversed array is: ");  // 打印反转后的数组
        for (double num : arr) {
            System.out.print(num + " ");  // 遍历打印每个元素的值
        }
        sc.close();  // 关闭扫描器
    }
}