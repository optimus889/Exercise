package class07;

import java.util.ArrayDeque;
import java.util.Deque;

public class DelimitedARDeque<T> extends ARDeque<T> {

    @Override
    public void addFirst(T item) {
        // 统计item在队列中的出现次数
        int count = 0;
        for (T element : this) {
            if (element.equals(item)) {
                count++;
            }
        }

        // 如果item出现次数超过一次，抛出IllegalArgumentException
        if (count >= 1) {
            throw new IllegalArgumentException("Item already occurs more than once.");
        }

        // 调用父类方法将item添加到队列前面
        super.addFirst(item);
    }

    // 测试方法
    public static void main(String[] args) {
        DelimitedARDeque<String> dd = new DelimitedARDeque<>();
        dd.addFirst("a");
        dd.addFirst("b");
        try {
            dd.addFirst("a");
            dd.printDeque();
        } catch (IllegalArgumentException e) {
            System.out.println("AddFirst failed");
        }
    }
}

// 父类ARDeque，假设继承自ArrayDeque并实现了可迭代接口
class ARDeque<T> extends ArrayDeque<T> {

    // 添加到队列前面的方法
    @Override
    public void addFirst(T item) {
        super.addFirst(item);
    }

    // 打印队列元素的方法
    public void printDeque() {
        for (T item : this) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

