package extra.lab1;

/*
The reverse method in the lecture reverses an array of integers by copying it to a new array and returning it.
Write a method reverseInPlace that reverses the array of doubles passed in the argument and returns nothing.
After that, write a test program that prompts the user to enter arbitrary numbers, invokes the method to reverse the numbers, and displays the array.
Your test program should first prompt the user to enter the array size.
Test the method on all kinds of input array
*/


import java.util.Scanner;

public class reverseInPlace {
    public static void reverseInPlace(double[] arr) {
        int min = 0;
        int max = arr.length - 1;
        while (min < max) {
            double temp = arr[min];
            arr[min] = arr[max];
            arr[max] = temp;

            min++;
            max--;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println ("Enter the size of the array: ");
        int size = sc.nextInt ();
        double[] arr = new double[size];
        System.out.println ("Enter " + size + " elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextDouble ();
        }
        reverseInPlace (arr);
        System.out.println ("The reversed array is: ");
        for (double num : arr) {
            System.out.print(num + " ");
        }
        sc.close ();
    }
}
