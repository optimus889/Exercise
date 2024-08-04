package extra.lab2;

import java.util.ArrayList;
import java.util.Scanner;
/*
In Lecture 2, we implement MyStack using composition.
Now, implement a new MyStack class that extends ArrayList Instead.
The class definition should be public class MyStack extends ArrayList<Object>
The methods are isEmpty(), getSize(), peek(), pop(), push(Object o),search(Object o) and toString().
Write a test program that prompts the user to enter five strings and displays them in reverse order.
*/
public class MyStack extends ArrayList<Object> {
    public boolean isEmpty(){
        return super.isEmpty();
    }

    public int getSize(){
        return super.size ();
    }

    public Object peek(){
        return get (getSize () - 1);
    }

    public Object pop(){
        Object o = get (getSize () - 1);
        remove (getSize () - 1);
        return o;
    }

    public Object push(Object o){
        add (o);
        return o;
    }

    public int search(Object o){
        return super.lastIndexOf (o);
    }

    @Override
    public String toString() {
        return "MyStack{" + super.toString () + "}";
    }
}
class MyStackTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the stack: ");
        for (int i = 0; i < 5; i++) {
            String input = sc.next();
            myStack.push (input);
        }
        System.out.println ("The strings in the reverse order are: ");
        while (!myStack.isEmpty()) {
            System.out.println (myStack.pop());
        }
        sc.close();
    }
}
