package extra.lab5;
/*程序源代码可以包含各种分组符号对，例如：
 小括号：（ 和 ）
 大括号：{ 和 }
 中括号：[ 和 ]
分组符号不能重叠。例如，（a{b）} 是非法的。
编写一个程序来检查程序源代码行是否有成对的分组符号。
您可以假设程序源代码行将从键盘输入。
下面是两个示例输入和输出。
输入: int a = (int) (“0.1”);
输出：配对
输入 public void static main(String[] args){
输出：不配对
*/
import java.util.Scanner;
import java.util.Stack;

public class GroupingSymbolsChecker {

    public static boolean isPaired(String code) {
        // 使用堆栈来检查分组符号
        Stack<Character> stack = new Stack<>();

        // 遍历代码中的每一个字符
        for (char ch : code.toCharArray()) {
            // 如果是左符号，压入堆栈
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // 如果是右符号，检查堆栈是否匹配
            else if (ch == ')' || ch == '}' || ch == ']') {
                // 如果堆栈为空，说明没有匹配的左符号
                if (stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                // 检查是否匹配
                if (ch == ')' && left != '(') {
                    return false;
                }
                if (ch == '}' && left != '{') {
                    return false;
                }
                if (ch == ']' && left != '[') {
                    return false;
                }
            }
        }
        // 如果堆栈为空，说明所有符号都匹配
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // 创建一个扫描器对象读取输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一行代码：");
        String code = scanner.nextLine();

        // 检查分组符号是否配对
        boolean result = isPaired(code);

        // 打印结果
        if (result) {
            System.out.println("配对");
        } else {
            System.out.println("不配对");
        }

        // 关闭扫描器
        scanner.close();
    }
}
