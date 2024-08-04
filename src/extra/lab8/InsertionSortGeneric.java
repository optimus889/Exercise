package extra.lab8;
/*
使用插入排序编写以下两种通用方法。
第一种方法使用 Comparable 接口对元素进行排序，第二种方法使用 Comparator 接口
公共静态<E 扩展 Comparable<E>>
void insertionSort（E[] 列表）
public static <E> void insertionSort（E[] list， Comparator<> super E comparator）
提示：
 给定列表为 {2， 3， 2， 5， 6， 1， -2， 3， 14， 12}
 充分利用 Java 的泛型，可以使用 Comparable 和 Comparator 对任何类型的对象进行排序
 了解插入排序算法的机制，该机制涉及通过将每个新元素与已排序的元素进行比较并将其插入到正确的位置，一次构建一个元素的排序列表。
*/
import java.util.Comparator;

public class InsertionSortGeneric {

    public static <E extends Comparable<E>> void insertionSort(E[] list) {
        for (int i = 1; i < list.length; i++) {
            E currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k].compareTo(currentElement) > 0; k--) {
                list[k + 1] = list[k];
            }
            list[k + 1] = currentElement;
        }
    }

    public static <E> void insertionSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 1; i < list.length; i++) {
            E currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && comparator.compare(list[k], currentElement) > 0; k--) {
                list[k + 1] = list[k];
            }
            list[k + 1] = currentElement;
        }
    }

    public static void main(String[] args) {
        Integer[] list1 = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        insertionSort(list1);
        System.out.println("使用 Comparable 接口排序后的数组:");
        for (int i : list1) {
            System.out.print(i + " ");
        }
        System.out.println();

        Integer[] list2 = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        insertionSort(list2, Comparator.naturalOrder());
        System.out.println("使用 Comparator 接口排序后的数组:");
        for (int i : list2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
