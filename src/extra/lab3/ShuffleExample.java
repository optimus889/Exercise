package extra.lab3;
/*
编写以下方法，用于对数字的 ArrayList 进行随机排序：
public static void shuffle（ArrayList<Number> 列表）
提示：
1. 首先创建 ArrayList
2. 在 shuffle（） 方法中，您可以考虑 Fisher-Yates 洗牌算法，该算法是高效洗牌。
3. 使用 Math.random（） 在列表大小范围内生成随机索引。
4. 将索引“i”处的元素与随机生成的索引处的元素交换以执行洗牌。
*/
import java.util.ArrayList;  // 导入ArrayList类

public class ShuffleExample {
    // shuffle方法，用于打乱一个Number类型的ArrayList列表
    public static void shuffle(ArrayList<Number> list) {
        // 从列表的末尾开始向前遍历
        for (int i = list.size() - 1; i > 0; i--) {
            // 生成一个随机索引j，范围从0到i（包括i）
            int j = (int) (Math.random() * (i + 1));
            // 获取当前索引i的元素
            Number temp = list.get(i);
            // 将随机索引j的元素放到索引i的位置
            list.set(i, list.get(j));
            // 将原本索引i的元素放到随机索引j的位置
            list.set(j, temp);
        }
    }

    // main方法，程序入口
    public static void main(String[] args) {
        ArrayList<Number> numbers = new ArrayList<>();  // 创建一个Number类型的ArrayList
        // 向列表中添加从0到9的整数
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        // 打印原始列表
        System.out.println("Original list: " + numbers);

        // 调用shuffle方法，打乱列表
        shuffle(numbers);

        // 打印打乱后的列表
        System.out.println("Shuffled list: " + numbers);
    }
}
