package stack.geek;

import java.util.ArrayList;
import java.util.Stack;

//155

/**
 * 最小栈，辅助栈实现
 */
class MinStack2 {

    private Stack<Integer> datas = new Stack<>();
    private Stack<Integer> helpers = new Stack<>();

    // 1,-1,-2
    /** initialize your data structure here. */
    public MinStack2() {
        
    }
    
    public void push(int x) {
        datas.push(x);
        if (helpers.isEmpty() || x < helpers.peek()) {
            helpers.push(x);
        }
    }

    public void pop() {
        if (datas.isEmpty()) {
            return;
        }

        int data = datas.peek();
        int helper = helpers.peek();
        datas.pop();

        if (data == helper) {
            helpers.pop();
        }

    }
    
    public int top() {
        if (datas.isEmpty()) {
            throw new RuntimeException("failed.");
        }
        return datas.peek();
    }
    
    public int getMin() {
        if (helpers.isEmpty()) {
            throw new RuntimeException("failed.");
        }

        return helpers.peek();
    }

    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(-1);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.push(1);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
