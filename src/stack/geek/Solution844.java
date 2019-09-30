package stack.geek;

import java.util.Stack;

class Solution844 {

    //S = "ab#c", T = "ad#c" true
    //S = "ab##", T = "c#d#" true
    //S = "a##c", T = "#a#c" true
    //S = "a#c", T = "b" false

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        int lenLeft = S.length();
        int lenRight = T.length();

        int len = Math.max(lenLeft, lenRight);

        for (int i = 0; i < len; i++) {
            if (i < lenLeft) {
                char value = S.charAt(i);
                if (value != '#') {
                    left.push(value);
                } else {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                }
            }

            if (i < lenRight) {
                char value = T.charAt(i);
                if (value != '#') {
                    right.push(value);
                } else {
                    if (!right.isEmpty()) {
                        right.pop();
                    }
                }
            }
        }

        if (left.size() != right.size()) {
            return false;
        }

        if (left.isEmpty()) {
            return true;
        }

        while (!left.isEmpty()) {
            char leftPop = left.pop();
            char rightPop = right.pop();
            if (leftPop != rightPop) {
                left.clear();
                right.clear();
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution844 solution = new Solution844();
        System.out.println(solution.backspaceCompare("ab#c", "ad#c"));
        System.out.println(solution.backspaceCompare("ab##", "c#d#"));
        System.out.println(solution.backspaceCompare("a##c", "#a#c"));
        System.out.println(solution.backspaceCompare("a#c", "b"));
//        System.out.println(solution.isValid("){"));
    }
}