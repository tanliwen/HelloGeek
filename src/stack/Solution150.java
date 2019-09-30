package stack;
import java.util.Stack;

class Solution150 {

    // ["2", "1", "+", "3", "*"]   9  ((2 + 1) * 3) = 9
    // ["4", "13", "5", "/", "+"]  6  (4 + (13 / 5)) = 6
    // "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" 22
    public boolean isOperator(String operator) {
        return "+".equals(operator) || "-".equals(operator) || "*".equals(operator) || "/".equals(operator);
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            throw new RuntimeException("input error");
        }

        Stack<Integer> data = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int data1 = data.pop();
                int data2 = data.pop();
                char currentOperator = token.charAt(0);
                if (currentOperator == '+') {
                    data.push(data2 + data1);
                } else if (currentOperator == '-') {
                    data.push(data2 - data1);
                } else if (currentOperator == '*') {
                    data.push(data2 * data1);
                } else {
                    // /
                    data.push(data2 / data1);
                }
            } else {
                data.push(Integer.parseInt(token));
            }
        }

        if (data.size() != 1) {
            throw new RuntimeException("input error");
        }

        return data.pop();
    }

    public static void main(String[] args) {
        Solution150 solution = new Solution150();
        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}