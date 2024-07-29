package class05;

public class InsertionSort {

    /**
     * 插入排序算法
     *
     * @param arr 要排序的数组
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length; // 获取数组的长度
        for (int i = 1; i < n; i++) { // 从数组的第二个元素开始遍历
            int key = arr[i]; // 记录当前元素
            int j = i - 1; // 记录当前元素的前一个元素的索引

            // 将当前元素插入到已排序部分的正确位置
            while (j >= 0 && arr[j] > key) { // 如果前一个元素大于当前元素
                arr[j + 1] = arr[j]; // 将前一个元素向后移动
                j = j - 1; // 继续向前比较
            }
            arr[j + 1] = key; // 将当前元素插入到正确位置
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
     * 主函数，用于测试插入排序算法
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90}; // 要排序的数组
        System.out.println("排序前的数组:");
        printArray(arr); // 打印排序前的数组

        insertionSort(arr); // 调用插入排序算法

        System.out.println("排序后的数组:");
        printArray(arr); // 打印排序后的数组
    }
}

