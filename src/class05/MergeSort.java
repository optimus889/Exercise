package class05;

public class MergeSort {

    // 合并两个子数组 arr[l..m] 和 arr[m+1..r]
    public static void merge(int[] arr, int l, int m, int r) {
        // 找出两个子数组的大小
        int n1 = m - l + 1;
        int n2 = r - m;

        // 创建临时数组
        int[] L = new int[n1];
        int[] R = new int[n2];

        // 将数据复制到临时数组
        System.arraycopy(arr, l, L, 0, n1);
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        // 合并临时数组

        // 初始化合并的初始索引
        int i = 0, j = 0;

        // 初始索引数组的子数组
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // 复制L[]的剩余元素
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // 复制R[]的剩余元素
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // 主函数来排序数组 arr[l..r] 使用 merge()
    public static void sort(int[] arr, int l, int r) {
        if (l < r) {
            // 找到中间点
            int m = (l + r) / 2;

            // 排序第一和第二个子数组
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // 合并排序的子数组
            merge(arr, l, m, r);
        }
    }

    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }


    // 测试主函数
    public static void main(String[] args) {

        test(10);

        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("给定数组");
        printArray(arr);

        MergeSort.sort(arr, 0, arr.length - 1);

        System.out.println("\n排序后的数组");
        printArray(arr);
    }

    // 打印数组
    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
