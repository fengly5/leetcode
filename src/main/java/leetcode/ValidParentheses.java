package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class ValidParentheses {

    public static boolean isValid(String s) {

        //提前判断条件是否满足
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        //用栈来进行存储
        Stack<Character> charsStack = new Stack<Character>();
        //map来记录匹配的字符串
        final Map<Character, Character> charMap = new HashMap<Character, Character>() {{
            put(']', '[');
            put('}', '{');
            put('》', '《');
            put('\'', '\'');
            put('\"', '\"');
            put('>', '<');
        }};
        for (char c : s.toCharArray()) {
            if (charMap.containsKey(c)) {
                //能合并成一个if判断的不要用多个
                if (charsStack.size() == 0 || !charMap.get(c).equals(charsStack.peek())) {
                    return false;
                }
                charsStack.pop();
            } else {
                charsStack.push(c);
            }
        }
        return charsStack.isEmpty();//返回值可以用表达式
    }

    public static void main(String[] args) {
//        String str = "{}";
//        String str = "}";
        String str = "";
        System.out.println(isValid(str));
    }
}
