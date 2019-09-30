package stack.geek;

import java.util.Stack;

class Solution232 {
    static class MyQueue {
        private Stack<Integer> data;
        private Stack<Integer> dataHelper;

        /** Initialize your data structure here. */

        //1,2,3,4
        public MyQueue() {
            data = new Stack<>();
            dataHelper = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            data.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (data.isEmpty()) {
                throw new RuntimeException("queue is empty.");
            }
            while (!data.isEmpty()) {
                dataHelper.push(data.pop());
            }
            int value = dataHelper.pop();
            while (!dataHelper.isEmpty()) {
                data.push(dataHelper.pop());
            }
            return value;
        }

        /** Get the front element. */
        public int peek() {
            if (data.isEmpty()) {
                throw new RuntimeException("queue is empty.");
            }
            while (!data.isEmpty()) {
                dataHelper.push(data.pop());
            }
            int value = dataHelper.peek();
            while (!dataHelper.isEmpty()) {
                data.push(dataHelper.pop());
            }

            return value;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return data.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution232.MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // 返回 1
        System.out.println(queue.pop());   // 返回 1
        System.out.println(queue.empty()); // 返回 false
    }
}