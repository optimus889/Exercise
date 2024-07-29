package class05;

public class QuickSort {

    /**
     * 快速排序算法
     *
     * @param arr   要排序的数组
     * @param left  左边界的索引
     * @param right 右边界的索引
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) { // 确保左边界索引小于右边界索引
            int pivotIndex = partition(arr, left, right); // 获取分区点索引
            quickSort(arr, left, pivotIndex - 1); // 对左半部分进行递归排序
            quickSort(arr, pivotIndex + 1, right); // 对右半部分进行递归排序
        }
    }

    /**
     * 分区方法
     *
     * @param arr   要分区的数组
     * @param left  左边界的索引
     * @param right 右边界的索引
     * @return 分区点的索引
     */
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // 选择最右边的元素作为基准
        int i = left - 1; // 初始化i为左边界索引减1
        //          2   3   4   6   5
        //                          j
        //          left            right
        //          pivot = 4       i = 1
        for (int j = left; j < right; j++) { // 从左边界到右边界-1进行遍历
            if (arr[j] < pivot) { // 如果当前元素小于基准
                i++; // 增加i的值
                // 交换arr[i]和arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 将基准元素放置到正确位置
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1; // 返回分区点索引
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
     * 主函数，用于测试快速排序算法
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90}; // 要排序的数组
        System.out.println("排序前的数组:");
        printArray(arr); // 打印排序前的数组

        quickSort(arr, 0, arr.length - 1); // 调用快速排序算法

        System.out.println("排序后的数组:");
        printArray(arr); // 打印排序后的数组
    }
}

