package class05;

public class HeapSort {

    /**
     * 堆排序算法
     *
     * @param arr 要排序的数组
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 构建最大堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 逐个从堆顶取出最大元素，并调整堆
        for (int i = n - 1; i > 0; i--) {
            // 将当前堆顶（最大元素）与数组末尾元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 调整堆
            heapify(arr, i, 0);
        }
    }

    /**
     * 堆调整方法
     *
     * @param arr   要调整的数组
     * @param n     堆的大小
     * @param i     当前节点的索引
     */
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // 初始化最大元素索引为当前节点
        int left = 2 * i + 1; // 左子节点索引
        int right = 2 * i + 2; // 右子节点索引

        // 如果左子节点大于当前节点，则更新最大元素索引
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 如果右子节点大于当前最大元素，则更新最大元素索引
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大元素不是当前节点，则交换并继续调整堆
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // 递归调整受影响的子堆
            heapify(arr, n, largest);
        }
    }

    /**
     * 打印数组
     *
     * @param arr 要打印的数组
     */
    public static void printArray(int[] arr) {
        MergeSort.printArray(arr); // 换行
    }

    /**
     * 主函数，用于测试堆排序算法
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90}; // 要排序的数组
        System.out.println("排序前的数组:");
        printArray(arr); // 打印排序前的数组

        heapSort(arr); // 调用堆排序算法

        System.out.println("排序后的数组:");
        printArray(arr); // 打印排序后的数组
    }
}

