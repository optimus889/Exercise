package extra.lab2;
/*
编写一个函数，该函数打印前 10 个数字，其中包含 50 位小数，可以被 2 或 3 整除
*/

// 导入BigInteger类，支持任意精度的整数计算
import java.math.BigInteger;

public class LargeNumberDivisibility {
    public static void main(String[] args) {
        // 创建一个初始值为10的50次方的BigInteger对象
        BigInteger start = new BigInteger("1" + "0".repeat(49));
        int count = 0;  // 计数器，用于记录找到的符合条件的数字的数量

        // 当找到的符合条件的数字少于10个时，继续循环
        while (count < 10) {
            // 检查当前数字是否能被2或者3整除
            if (start.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO) ||
                    start.mod(BigInteger.valueOf(3)).equals(BigInteger.ZERO)) {
                System.out.println(start);  // 打印符合条件的数字
                count++;  // 更新符合条件的数字的计数
            }
            start = start.add(BigInteger.ONE);  // 将当前数字加1，继续检查下一个数字
        }
    }
}
