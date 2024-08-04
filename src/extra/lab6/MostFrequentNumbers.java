package extra.lab6;
/*
编写一个程序，该程序读取未指定数量的整数，并找到出现次数最多的整数。
当输入为 0 时，输入结束。例如，如果输入 2 3 40 3 5 4 –3 3 3 2 0，则数字 3 出现频率最高。
如果不是一个数字出现次数最多，而是出现次数最多的数字，则应报告所有数字。
例如，由于 9 和 3 在列表 9 30 3 9 3 2 4 中出现两次，因此应报告两次出现。
提示：
 使用地图跟踪事件：考虑使用地图数据结构，其中每个键都是一个
输入的唯一整数，每个值都是该整数的出现次数。
 更新映射中的计数：读取每个整数时，更新其在映射中的相应计数。
如果整数尚未在映射中，则将其与计数 1 相加。如果它已经在地图中，则增加其计数。
 查找最大计数：读取所有整数后，在映射中找到最大计数值。
这表示任何数字出现次数最多的次数。
 识别出现次数最多的数字：遍历地图以查找所有出现次数最多的数字并打印出来。
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostFrequentNumbers {
    public static void main(String[] args) {
        // 创建一个 Scanner 对象读取输入
        Scanner scanner = new Scanner(System.in);

        // 创建一个 HashMap 来存储每个整数及其出现次数
        Map<Integer, Integer> occurrences = new HashMap<>();

        System.out.println("请输入整数（输入0结束）：");

        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            occurrences.put(number, occurrences.getOrDefault(number, 0) + 1);
        }

        // 关闭 Scanner
        scanner.close();

        // 找到最大出现次数
        int maxCount = 0;
        for (int count : occurrences.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        // 找到所有具有最大出现次数的整数
        System.out.print("出现次数最多的数字是：");
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() == maxCount) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
