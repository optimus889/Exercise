package extra.lab1;
/*
设计一个名为StopWatch的类。
该类包含：
私有数据字段startTime和endTime，以及它们的获取方法。
一个空构造函数，初始化startTime和endTime为当前时间。
一个名为start()的方法，将startTime重置为当前时间。
一个名为stop()的方法，将endTime设置为当前时间。
一个名为getElapsedTime()的方法，返回秒表的经过时间（startTime与endTime之间的差），
以毫秒为单位。
注意，你可以使用System.currentTimeMillis()获取当前时间。
*/
import java.util.Random;  // 导入Random类，用于生成随机数

public class StopWatch {
    private long startTime;  // 私有变量，记录开始时间
    private long endTime;    // 私有变量，记录结束时间

    public StopWatch() {  // 构造函数，初始化startTime和endTime为当前时间
        this.startTime = System.currentTimeMillis();
        this.endTime = System.currentTimeMillis();
    }

    public long getEndTime() {  // 获取endTime的方法
        return endTime;
    }

    public long getStartTime() {  // 获取startTime的方法
        return startTime;
    }

    public void start(){  // start方法，将startTime重置为当前时间
        this.startTime = System.currentTimeMillis();
    }

    public void stop(){  // stop方法，将endTime设置为当前时间
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime(){  // getElapsedTime方法，返回经过的时间
        return this.endTime - this.startTime;
    }

}

// 测试StopWatch类的功能
class StopWatchTest{
    public static void main(String[] args) {
        int[] numbers = new int[100000];  // 创建一个包含100000个元素的数组
        Random random = new Random();  // 创建Random对象

        // 用随机数填充数组
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000000);
        }
        StopWatch stopWatch = new StopWatch();  // 创建StopWatch对象
        stopWatch.start();  // 开始计时
        selectionSort(numbers);  // 使用选择排序对数组进行排序
        stopWatch.stop();  // 停止计时

        long elapsedTime = stopWatch.getElapsedTime();  // 获取经过的时间
        System.out.println("Elapsed time: " + elapsedTime + "ms");  // 打印经过的时间
    }

    // 选择排序算法的实现
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;  // 寻找最小元素的索引
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;  // 更新最小元素的索引
                }
            }
            int temp = array[minIndex];  // 交换元素
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}