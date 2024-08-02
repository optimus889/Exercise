package class07;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ARDeque1<T> extends ArrayDeque<T> {

    @Override
    public boolean equals(Object that) {
        // 检查是否为同一对象
        if (this == that) {
            return true;
        }

        // 检查是否为ARDeque实例
        if (!(that instanceof ARDeque1)) {
            return false;
        }

        ARDeque1<?> otherDeque = (ARDeque1<?>) that;

        // 检查两个队列的大小是否相同
        if (this.size() != otherDeque.size()) {
            return false;
        }

        // 比较两个队列中的元素
        Iterator<T> thisIterator = this.iterator();
        Iterator<?> thatIterator = otherDeque.iterator();

        int differences = 0;

        while (thisIterator.hasNext() && thatIterator.hasNext()) {
            T thisItem = thisIterator.next();
            Object thatItem = thatIterator.next();

            if (!thisItem.equals(thatItem)) {
                differences++;
            }

            // 如果超过一个不同的元素，返回false
            if (differences > 1) {
                return false;
            }
        }

        // 如果最多只有一个不同的元素，返回true
        return true;
    }

    public static void main(String[] args) {
        ARDeque1<Integer> deque1 = new ARDeque1<>();
        ARDeque1<Integer> deque2 = new ARDeque1<>();

        deque1.add(1);
        deque1.add(2);
        deque1.add(3);

        deque2.add(1);
        deque2.add(2);
        deque2.add(5);

        System.out.println(deque1.equals(deque2)); // 应输出 true

        ARDeque1<Integer> deque3 = new ARDeque1<>();
        deque3.add(1);
        deque3.add(3);
        deque3.add(2);

        System.out.println(deque1.equals(deque3)); // 应输出 false
    }
}
