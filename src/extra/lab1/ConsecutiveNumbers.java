package extra.lab1;
/*
Write the following method that tests whether the array has four consecutive numbers with the same value:
public static boolean isConsecutiveFour(int[] values)
After that, write a test program that prompts the user to enter a series of integers and displays it if the series contains four consecutive numbers with the same value.
Your program should first prompt the user to enter the input size—i.e., the number of values in the series.
Test the method on all kinds of input values.
*/

import java.util.Scanner;

public class ConsecutiveNumbers {
    public static boolean isConsecutive(int[] value) {
        if (value.length < 4){
            return false;
        }
        for (int i = 0; i < value.length - 4; i++) {
            if (value[i] == value[i+1] && value[i] == value[i+2] && value[i] == value[i+3]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number in the series: ");
        int size = sc.nextInt();
        int[] value = new int[size];
        System.out.println ("Enter " + size + " values: ");
        for (int i = 0; i < size; i++) {
            value[i] = sc.nextInt();
        }
        boolean result = isConsecutive(value);
        if (result){
            System.out.println ("Consecutive numbers are true");
        }else {
            System.out.println ("Consecutive numbers are false");
        }
        sc.close();
    }
}
