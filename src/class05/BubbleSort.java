package class05;

public class BubbleSort {

    /**
     * 冒泡排序算法
     *
     * @param arr 要排序的数组
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length; // 数组的长度
        for (int i = 0; i < n - 1; i++) { // 外层循环：控制排序的轮数，共n-1轮
            for (int j = 0; j < n - 1 - i; j++) { // 内层循环：每一轮比较的次数逐渐减少
                if (arr[j] < arr[j + 1]) { // 如果前面的元素大于后面的元素
                    // 交换arr[j]和arr[j+1]
                    int temp = arr[j]; // 用temp临时存储arr[j]
                    arr[j] = arr[j + 1]; // 将arr[j+1]的值赋给arr[j]
                    arr[j + 1] = temp; // 将temp的值赋给arr[j+1]
                }
            }
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
     * 主函数，用于测试冒泡排序算法
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90}; // 要排序的数组
        System.out.println("排序前的数组:");
        printArray(arr); // 打印排序前的数组

        bubbleSort(arr); // 调用冒泡排序算法

        System.out.println("排序后的数组:");
        printArray(arr); // 打印排序后的数组
    }
}
