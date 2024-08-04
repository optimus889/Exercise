package extra.lab4;
/*
根据您在上述练习 4.1 中的答案，编写一个返回 ArrayList 中最大元素的方法。
该方法应从以下标识符开始：
public static <E extends Comparable<E>> E
*/
import java.util.ArrayList;

public class GenericMaxElement {
    // 返回 ArrayList 中的最大元素
    public static <E extends Comparable<E>> E getMaxElement(ArrayList<E> list) {
        if (list == null || list.isEmpty()) {
            return null; // 如果列表为空或为 null，返回 null
        }

        E maxElement = list.get(0); // 假设第一个元素为最大元素
        for (E element : list) {
            if (element.compareTo(maxElement) > 0) {
                maxElement = element; // 更新最大元素
            }
        }

        return maxElement;
    }

    public static void main(String[] args) {
        // 创建一个包含 Integer 对象的 ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add((int) (Math.random() * 100)); // 添加随机整数
        }

        // 打印原始列表
        System.out.println("原始列表: " + numbers);

        // 获取并打印列表中的最大元素
        Integer maxElement = getMaxElement(numbers);
        System.out.println("最大元素: " + maxElement);
    }
}
