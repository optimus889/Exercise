package extra.lab5;
/*
编写一个程序，创建两个优先级队列,{"George", "Jim", "John", "Blake", "Kevin", "Michael"}
和 {"George", "Katie", "Kevin", "Michelle", "Ryan"}并显示它们的并集、差异和交集。
任务指南：
（1） 使用 PriorityQueue 的 addAll（） 方法获取两个优先级队列的并集。
（2） 使用 PriorityQueue 的 removeAll（） 方法获取两个优先级队列的差异。
（3） 使用 PriorityQueue 的 retainAll（） 方法获取交集
*/
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // 创建两个优先队列
        PriorityQueue<String> queue1 = new PriorityQueue<>();
        PriorityQueue<String> queue2 = new PriorityQueue<>();

        // 向第一个优先队列添加元素
        queue1.add("George");
        queue1.add("Jim");
        queue1.add("John");
        queue1.add("Blake");
        queue1.add("Kevin");
        queue1.add("Michael");

        // 向第二个优先队列添加元素
        queue2.add("George");
        queue2.add("Katie");
        queue2.add("Kevin");
        queue2.add("Michelle");
        queue2.add("Ryan");

        // 计算并集
        PriorityQueue<String> unionQueue = new PriorityQueue<>(queue1);
        unionQueue.addAll(queue2);
        System.out.println("并集: " + unionQueue);

        // 计算差集
        PriorityQueue<String> differenceQueue = new PriorityQueue<>(queue1);
        differenceQueue.removeAll(queue2);
        System.out.println("差集: " + differenceQueue);

        // 计算交集
        PriorityQueue<String> intersectionQueue = new PriorityQueue<>(queue1);
        intersectionQueue.retainAll(queue2);
        System.out.println("交集: " + intersectionQueue);
    }
}
