package class03;

import java.util.Arrays;

class MyStack<E> {
    private Object[] elements;
    private int size = 0;

    public MyStack() {
       this(10);
    }

    public MyStack(int capacity) {
        if(capacity <= 0){
            throw new RuntimeException("capacity must be greater than 0");
        }
        elements = new Object[capacity];
    }

    public void push(E e) {
       if(size >= elements.length){
           expandCapacity();
       }
       elements[size++] = e;
    }

    private void expandCapacity() {
        int oldCapacity = elements.length;
        Object[] old = elements;
        int newCapacity = oldCapacity * 2;
        elements = new Object[newCapacity];
        System.arraycopy(old, 0, elements, 0, oldCapacity);
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object object = peek();
        elements[--size] = null;
        return object;
    }

    public Object peek() {
        int len = size();
        return elements[len];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void print(){
        System.out.println(Arrays.toString(elements)+"\n");
    }
}

public class GenericStack {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("This");
        stack.push("is");
        stack.push("a");
        stack.push("test");
        stack.push("case");
        stack.print();
        System.out.println("pop-->"+stack.pop());
        stack.print();
        System.out.println("peek-->"+stack.peek());
        System.out.println("pop-->"+stack.pop());
        stack.print();
        System.out.println("pop-->"+stack.pop());
        stack.print();
        stack.push("demo");
        System.out.println("peek-->"+stack.peek());
        stack.print();
        System.out.println("stack.isEmpty()-->"+stack.isEmpty());
        System.out.println("stack.size()-->"+stack.size());
    }
}
