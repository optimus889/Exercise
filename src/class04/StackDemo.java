package class04;

//         给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//        有效字符串需满足：
//
//        左括号必须用相同类型的右括号闭合。
//        左括号必须以正确的顺序闭合。
//        每个右括号都有一个对应的相同类型的左括号。

import java.util.Stack;
public class StackDemo {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if(c == ')'&& stack.pop() != '(') {
                    return false;
                }if (c == ']' &&  stack.pop() != '[') {
                    return false;
                }if (c == '}' &&  stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        StackDemo stackDemo = new StackDemo();
        StackDemo solution = new StackDemo();

        // 测试用例，输出是否与预期一致
        check(solution.isValid(""), true);  // 应为 true
        check(solution.isValid("()"), true);  // 应为 true
        check(solution.isValid("{}"), true);  // 应为 true
        check(solution.isValid("[]"), true);  // 应为 true
        check(solution.isValid("()[]{}"), true);  // 应为 true
        check(solution.isValid("{[()]}"), true);  // 应为 true
        check(solution.isValid("(]"), false);  // 应为 false
        check(solution.isValid("([)]"), false);  // 应为 false
        check(solution.isValid("{[(])}"), false);  // 应为 false
        check(solution.isValid("((()"), false);  // 应为 false
        check(solution.isValid("()))"), false);  // 应为 false
        check(solution.isValid("{[()()[]{}]}"), true);  // 应为 true
        check(solution.isValid("{[(])}[{}]"), false);  // 应为 false
    }

    private static void check(boolean result, boolean expected) {
        if (result == expected) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail: Expected " + expected + ", but got " + result);
        }
    }
}
