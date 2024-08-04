package extra.lab5;
/*
在讲座中，我们讨论了使用迭代器比使用 get（）方法遍历列表更有效。
有关详细信息，请参阅第 5 讲第 30 页。在本练习中，您将测试差异。
任务指南：
（1） 创建一个包含 100,000 个整数对象的 LinkedList。
（2） 使用 System.currentTimeMillis（） 创建计时器。
（3） 使用 get（） 方法遍历 LinkedList。记录所消耗的时间。
（4） 使用迭代器遍历 LinkedList。记录所消耗的时间。
输出上述两个时间值。
*/
import java.util.LinkedList;
import java.util.ListIterator;

public class EfficiencyTest {
    public static void main(String[] args) {
        // 步骤1: 创建一个包含100,000个Integer对象的LinkedList
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }

        // 步骤2: 创建一个计时器
        long startTime, endTime, elapsedTimeUsingGet, elapsedTimeUsingIterator;

        // 步骤3: 使用get()方法遍历LinkedList并记录所消耗的时间
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.currentTimeMillis();
        elapsedTimeUsingGet = endTime - startTime;

        // 步骤4: 使用迭代器遍历LinkedList并记录所消耗的时间
        startTime = System.currentTimeMillis();
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        endTime = System.currentTimeMillis();
        elapsedTimeUsingIterator = endTime - startTime;

        // 输出两种方法遍历所花费的时间
        System.out.println("Time consumed using get(): " + elapsedTimeUsingGet + " ms");
        System.out.println("Time consumed using iterator: " + elapsedTimeUsingIterator + " ms");
    }
}
