package extra.lab1;
/*
编写以下方法，用来检测数组中是否存在四个连续相同的数字：
public static boolean isConsecutiveFour(int[] values)
之后，编写一个测试程序，提示用户输入一系列整数，并在序列中包含四个连续相同的数字时显示出来。
你的程序应该首先提示用户输入输入的大小——即序列中的数值数量。
在各种输入值上测试该方法。
*/

// 导入Java的扫描器类，用于读取用户输入
import java.util.Scanner;

public class ConsecutiveNumbers {
    // 定义一个方法来检查数组中是否有四个连续相同的数字
    public static boolean isConsecutive(int[] value) {
        // 如果数组长度小于4，直接返回false，因为不可能有四个连续的数
        if (value.length < 4){
            return false;
        }
        // 遍历数组，检查连续四个数是否相同
        for (int i = 0; i < value.length - 4; i++) {
            if (value[i] == value[i+1] && value[i] == value[i+2] && value[i] == value[i+3]) {
                return true;  // 如果找到四个连续相同的数，返回true
            }
        }
        return false;  // 如果遍历完毕没有找到，返回false
    }

    // 主方法，程序执行的入口
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // 创建一个扫描器对象来读取输入
        System.out.println("Enter the number in the series: ");  // 提示用户输入数组长度
        int size = sc.nextInt();  // 读取数组长度
        int[] value = new int[size];  // 创建一个指定长度的数组
        System.out.println ("Enter " + size + " values: ");  // 提示用户输入数组的元素
        for (int i = 0; i < size; i++) {  // 循环读取每个元素的值
            value[i] = sc.nextInt();  // 将用户输入的值存储在数组中
        }
        boolean result = isConsecutive(value);  // 调用isConsecutive方法检查数组
        if (result){
            System.out.println ("Consecutive numbers are true");  // 如果返回true，输出连续四个相同的数为真
        }else {
            System.out.println ("Consecutive numbers are false");  // 如果返回false，输出连续四个相同的数为假
        }
        sc.close();  // 关闭扫描器
    }
}
