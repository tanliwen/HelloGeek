package stack.geek;

import java.util.LinkedList;
import java.util.Queue;

class Solution225 {
    class MyStack {

        Queue<Integer> data;
        Queue<Integer> dataHelper;

        int front;

        /** Initialize your data structure here. */
        public MyStack() {
            data = new LinkedList<>();
            dataHelper = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            front = x;
            data.add(x);
        }

        //1,2,3,4
        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            dataHelper.clear();
            while (data.size() > 1) {
                int front = data.remove();
                dataHelper.add(front);
            }
            if (data.size() != 1) {
               throw new IllegalArgumentException("input failed.");
            }
            int front = data.remove();
            while (!dataHelper.isEmpty()) {
                push(dataHelper.remove());
            }
            return front;
        }

        /** Get the top element. */
        public int top() {
            return front;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return data.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution225 solution = new Solution225();
    }
}