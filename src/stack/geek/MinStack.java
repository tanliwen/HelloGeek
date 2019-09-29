package stack.geek;

import java.util.ArrayList;

//155
class MinStack {

    private ArrayList<Integer> elementDatas = new ArrayList<>();

    private int currentSize = 0;

    private int min;

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (currentSize == 0) {
            min = x;
        } else {
            if (x < min) {
                min = x;
            }
        }
        elementDatas.add(x);
        currentSize++;
    }

    private void refreshMin() {
        int i = 0;
        for (Integer data: elementDatas) {
            if (i == 0) {
                min = data;
            } else {
                if (data < min) {
                    min = data;
                }
            }
            i++;
        }
    }

    public void pop() {
        if (currentSize <= 0) {
            return;
        }
        int data = elementDatas.remove(currentSize - 1);
        if (data == min) {
            refreshMin();
        }
        --currentSize;
    }
    
    public int top() {
        if (currentSize >= 1) {
            return elementDatas.get(currentSize - 1);
        } else {
            return 0;
        }
    }
    
    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-1);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.push(1);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
