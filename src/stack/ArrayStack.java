package stack;

/**
 * 栈，数组实现(固定大小，非线程安全)
 */
public class ArrayStack<T> {
    private int DEFAULT_MAX_CAPACITY = 10;
    private int currentSize = 0;
    private int maxSize;

    private transient Object[] elementData;

    public ArrayStack(int maxSize) {
        if (maxSize > 0) {
            this.maxSize = maxSize;
        } else {
            this.maxSize = DEFAULT_MAX_CAPACITY;
        }
        elementData = new Object[maxSize];
    }

    public boolean push(T t) {
        if (t == null) {
            System.out.println("Push stack data is null.");
            return false;
        }
        if (currentSize < maxSize) {
            elementData[currentSize] = t;
            ++currentSize;
            return true;
        } else {
            System.out.println("Stack is full.");
            return false;
        }
    }

    public T pop() {
        if (currentSize <= 0) {
            return null;
        }
        T t = (T) elementData[currentSize - 1];
        --currentSize;
        return t;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> datas = new ArrayStack<>(3);
        datas.push(1);
        datas.push(2);
        datas.push(3);
        datas.push(4);

        System.out.println(datas.pop());
        System.out.println(datas.pop());
        System.out.println(datas.pop());
        System.out.println(datas.pop());
    }
}
