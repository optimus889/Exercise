package extra.lab7;
/*
编写一种方法，使用分而治之的方法在列表中找到最大的数字。
提示：
 给定列表为 178、33、4、2、-3、5
 认识到，如果列表只有一个元素，那么该元素本质上是最大的。
对于包含两个元素的列表，只需直接比较它们即可。
 计算中间索引，将数组分成两半。
这将使该方法能够递归地找到每半中的最大数字。
 一旦您得到每半份的最大数字，请比较这两个数字以确定总体上的最大数字。
在这里，你可以结合结果来解决更大的问题
*/
public class DivideAndConquerMax {

    // 使用分治法找到列表中的最大数
    public static int findMax(int[] list, int start, int end) {
        // 如果列表中只有一个元素，则该元素是最大的
        if (start == end) {
            return list[start];
        }

        // 如果列表中有两个元素，直接比较它们
        if (end == start + 1) {
            return Math.max(list[start], list[end]);
        }

        // 计算中间索引，将列表分成两半
        int mid = (start + end) / 2;

        // 递归地找到每半的最大数
        int leftMax = findMax(list, start, mid);
        int rightMax = findMax(list, mid + 1, end);

        // 比较两半的最大数，返回整体的最大数
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] list = {178, 33, 4, 2, -3, 5};

        // 调用 findMax 方法，查找列表中的最大数
        int max = findMax(list, 0, list.length - 1);

        // 打印最大数
        System.out.println("列表中的最大数是：" + max);
    }
}
