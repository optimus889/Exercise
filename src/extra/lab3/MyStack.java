package extra.lab3;
/*
重写 Lecture 2.2（第 43 页）中的 MyStack 类，以执行列表字段的深度复制。
提示：
1. 在 MyStack 类中实现 Cloneable 接口以启用克隆功能。
2. 重写 MyStack 类中的克隆方法，以创建列表字段的深度副本。
3. 在克隆方法中，克隆列表中的每个对象以确保进行深度复制。
*/
import java.util.ArrayList;

public class MyStack implements Cloneable {
    private ArrayList<Object> list;

    // 构造函数
    public MyStack() {
        list = new ArrayList<>();
    }

    // 检查堆栈是否为空
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // 获取堆栈的大小
    public int getSize() {
        return list.size();
    }

    // 查看堆栈的顶部元素
    public Object peek() {
        return list.get(getSize() - 1);
    }

    // 弹出堆栈的顶部元素
    public Object pop() {
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    // 将元素推送到堆栈上
    public Object push(Object o) {
        list.add(o);
        return o;
    }

    // 在堆栈中搜索元素并返回其位置
    public int search(Object o) {
        return list.lastIndexOf(o);
    }

    // 重写 toString 方法以显示堆栈
    @Override
    public String toString() {
        return "MyStack: " + list.toString();
    }

    // 实现克隆方法进行深度复制
    @Override
    public Object clone() {
        try {
            MyStack cloned = (MyStack) super.clone();
            cloned.list = new ArrayList<>();
            for (Object obj : list) {
                // 假设列表中的对象是可克隆的
                if (obj instanceof Cloneable) {
                    cloned.list.add(deepClone(obj));
                } else {
                    cloned.list.add(obj); // 如果不可克隆，只需添加相同的引用即可
                }
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    // 用于深度克隆对象的帮助者方法
    private Object deepClone(Object obj) {
        try {
            return obj.getClass().getMethod("clone").invoke(obj);
        } catch (Exception e) {
            return obj;
        }
    }

    public static void main(String[] args) {
        MyStack stack1 = new MyStack();
        stack1.push("A");
        stack1.push("B");
        stack1.push("C");

        // 将 stack1 克隆到 stack2
        MyStack stack2 = (MyStack) stack1.clone();

        // 打印两个堆栈
        System.out.println("Original stack: " + stack1);
        System.out.println("Cloned stack: " + stack2);

        // 修改原始堆栈
        stack1.pop();
        stack1.push("D");

        // 修改后打印两个堆栈
        System.out.println("Original stack after modification: " + stack1);
        System.out.println("Cloned stack after original modification: " + stack2);
    }
}
