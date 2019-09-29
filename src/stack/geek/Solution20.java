package stack.geek;

import java.util.Stack;

class Solution20 {

    // "()[]{}" "" "))" ")("
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        int len = s.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char value = s.charAt(i);
            if (value == ']' || value == ')' || value == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if ((']' == value && '[' == top) || ('}' == value && '{' == top) || (')' == value && '(' == top)) {
                   continue;
                }
                stack.clear();
                return false;
            } else {
                stack.push(value);
            }
        }
        boolean flag = stack.isEmpty();
        stack.clear();
        return flag;
    }

    public static void main(String[] args) {
        Solution20 solution = new Solution20();
        System.out.println(solution.isValid("()[][]"));
//        System.out.println(solution.isValid("){"));
    }
}