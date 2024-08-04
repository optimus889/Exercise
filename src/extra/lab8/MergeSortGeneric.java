package extra.lab8;
/*
使用合并排序编写以下两种通用方法。
第一种方法使用 Comparable 接口对元素进行排序，第二种方法使用 Comparator 接口。
公共静态<E 扩展 Comparable<E>>
void mergeSort（E[] 列表）
public static <E> void mergeSort（E[] list， Comparator<？ super E> comparator）
提示：
 给定列表为 {2， 3， 2， 5， 6， 1， -2， 3， 14， 12}
 充分利用 Java 的泛型，可以使用 Comparable 和 Comparator 对任何类型的对象进行排序。
 递归地实现合并排序算法，将数组分成两半，对每一半进行排序，然后将它们合并回来。
*/
public class MergeSortGeneric {

    public static <E extends Comparable<E>> void mergeSort(E[] list) {
        if (list.length > 1) {
            // 分割数组为两半
            E[] firstHalf = (E[]) new Comparable[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            E[] secondHalf = (E[]) new Comparable[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // 合并两半
            merge(firstHalf, secondHalf, list);
        }
    }

    private static <E extends Comparable<E>> void merge(E[] firstHalf, E[] secondHalf, E[] list) {
        int current1 = 0; // Current index in firstHalf
        int current2 = 0; // Current index in secondHalf
        int current3 = 0; // Current index in list

        while (current1 < firstHalf.length && current2 < secondHalf.length) {
            if (firstHalf[current1].compareTo(secondHalf[current2]) < 0) {
                list[current3++] = firstHalf[current1++];
            } else {
                list[current3++] = secondHalf[current2++];
            }
        }

        while (current1 < firstHalf.length) {
            list[current3++] = firstHalf[current1++];
        }

        while (current2 < secondHalf.length) {
            list[current3++] = secondHalf[current2++];
        }
    }

    // 基于 Comparator 接口的归并排序
    public static <E> void mergeSort(E[] list, java.util.Comparator<? super E> comparator) {
        if (list.length > 1) {
            // 分割数组为两半
            E[] firstHalf = (E[]) new Object[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf, comparator);

            int secondHalfLength = list.length - list.length / 2;
            E[] secondHalf = (E[]) new Object[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf, comparator);

            // 合并两半
            merge(firstHalf, secondHalf, list, comparator);
        }
    }

    private static <E> void merge(E[] firstHalf, E[] secondHalf, E[] list, java.util.Comparator<? super E> comparator) {
        int current1 = 0; // Current index in firstHalf
        int current2 = 0; // Current index in secondHalf
        int current3 = 0; // Current index in list

        while (current1 < firstHalf.length && current2 < secondHalf.length) {
            if (comparator.compare(firstHalf[current1], secondHalf[current2]) < 0) {
                list[current3++] = firstHalf[current1++];
            } else {
                list[current3++] = secondHalf[current2++];
            }
        }

        while (current1 < firstHalf.length) {
            list[current3++] = firstHalf[current1++];
        }

        while (current2 < secondHalf.length) {
            list[current3++] = secondHalf[current2++];
        }
    }

    public static void main(String[] args) {
        Integer[] list1 = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        mergeSort(list1);
        System.out.println("使用 Comparable 接口排序后的数组:");
        for (int i : list1) {
            System.out.print(i + " ");
        }
        System.out.println();

        Integer[] list2 = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        mergeSort(list2, java.util.Comparator.naturalOrder());
        System.out.println("使用 Comparator 接口排序后的数组:");
        for (int i : list2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
