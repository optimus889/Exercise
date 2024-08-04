package extra.lab2;

import java.util.ArrayList;
import java.util.Scanner;
/*
在第 2 讲中，我们使用组合实现 MyStack。
现在，实现一个新的 MyStack 类，该类扩展了 ArrayList。
类定义应为公共类 MyStack 扩展 ArrayList<Object>
这些方法包括 isEmpty（）、getSize（）、peek（）、pop（）、push（Object o）、search（Object o） 和 toString（）。
编写一个测试程序，提示用户输入五个字符串，并以相反的顺序显示它们。
*/

// MyStack类继承自ArrayList<Object>，添加了栈的功能
public class MyStack extends ArrayList<Object> {
    // 检查栈是否为空
    public boolean isEmpty(){
        return super.isEmpty();
    }

    // 获取栈的大小
    public int getSize(){
        return super.size();
    }

    // 查看栈顶元素但不移除
    public Object peek(){
        return get(getSize() - 1);
    }

    // 移除并返回栈顶元素
    public Object pop(){
        Object o = get(getSize() - 1);
        remove(getSize() - 1);
        return o;
    }

    // 将一个元素推入栈顶
    public Object push(Object o){
        add(o);
        return o;
    }

    // 返回对象在栈中的位置，从栈顶开始计算
    public int search(Object o){
        return super.lastIndexOf(o);
    }

    // 重写toString方法，以字符串形式返回栈的内容
    @Override
    public String toString() {
        return "MyStack{" + super.toString() + "}";
    }
}

// 测试MyStack类的功能
class MyStackTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(); // 创建MyStack对象
        Scanner sc = new Scanner(System.in); // 创建Scanner对象，用于接收用户输入
        System.out.println("Enter the size of the stack: "); // 提示用户输入栈的大小，但实际代码中未使用大小输入
        for (int i = 0; i < 5; i++) { // 循环5次接收输入
            String input = sc.next(); // 读取用户输入的字符串
            myStack.push(input); // 将输入的字符串压入栈
        }
        System.out.println("The strings in the reverse order are: "); // 输出栈中的元素，这将是输入的反序
        while (!myStack.isEmpty()) { // 循环直到栈为空
            System.out.println(myStack.pop()); // 弹出并打印栈顶元素
        }
        sc.close(); // 关闭Scanner对象
    }
}
