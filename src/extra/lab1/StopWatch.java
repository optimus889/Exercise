package extra.lab1;

import java.util.Random;

/*
Design a class named StopWatch.
The class contains:
Private data fields startTime and endTime with getter methods.
An empty constructor that initializes startTime and endTime with the current time.
A method named start() that resets the startTime to the current time.
A method named stop() that sets the endTime to the current time.
A method named getElapsedTime() that returns the elapsed time (the difference between
stop and start time) for the stopwatch in milliseconds.
Note that you can use System.currentTimeMillis() to obtain the current time.
Write a test program that measures the execution time of sorting 100,000 numbers using
Selection Sort discussed during the lecture.
*/
public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis ();
        this.endTime = System.currentTimeMillis ();
    }

    public long getEndTime() {
        return endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void start(){
        this.startTime = System.currentTimeMillis ();
    }

    public void stop(){
        this.endTime = System.currentTimeMillis ();
    }

    public long getElapsedTime(){
        return this.endTime - this.startTime;
    }

}

class StopWatchTest{
    public static void main(String[] args) {
        int[] numbers = new int[100000];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt (1000000);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start ();
        selectionSort(numbers);
        stopWatch.stop ();

        long elapsedTime = stopWatch.getElapsedTime ();
        System.out.println("Elapsed time: " + elapsedTime + "ms");
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
