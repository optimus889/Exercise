package extra.lab4;
/*
再看一下上周的练习 3.1，在这个练习中，你被要求编写一个方法，使用数据结构 ArrayList 来打乱 ArrayList of Numbers<Number>。
现在我们已经学习了泛型类型。您的任务是修改数据结构以存储通用对象。
shuffle 方法应以下列格式的标识符开头：
public static <E> void shuffle(ArrayList<E> list)
*/
import java.util.ArrayList;

public class GenericShuffle {
    // 使用 Fisher-Yates 算法打乱泛型类型的 ArrayList
    public static <E> void shuffle(ArrayList<E> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            // 交换索引 i 和索引 j 处的元素
            E temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    public static void main(String[] args) {
        // 创建一个包含 Integer 对象的 ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        // 打印原始列表
        System.out.println("原始列表: " + numbers);

        // 打乱列表
        shuffle(numbers);

        // 打印打乱后的列表
        System.out.println("打乱后的列表: " + numbers);
    }
}
