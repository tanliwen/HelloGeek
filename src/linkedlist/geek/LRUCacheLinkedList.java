package linkedlist.geek;

import java.util.Scanner;

public class LRUCacheLinkedList<T> implements LRUCacheInterface<T>{

    private static final int DEFAULT_MAX_CAPACITY = 5;

    private int currentSize = 0;

    private int capacity = DEFAULT_MAX_CAPACITY;

    private Node<T> head;

    public LRUCacheLinkedList() {
        head = new Node<T>();
    }

    public LRUCacheLinkedList(int capacity) {
        this.capacity = capacity;
        head = new Node<T>();
    }

    @Override
    public void add(T element) {
        Node<T> data = findValueBefore(element);

        if (data != null) {
            deleteValueNext(data);
        }

        if (currentSize == DEFAULT_MAX_CAPACITY) {
            deleteEnd();
        }
        insertAtHead(element);
    }

    private void deleteValueNext(Node<T> elementData) {
        if (elementData == null) {
            return;
        }
        if (elementData.next == null) {
            return;
        }

        Node<T> waitDeleted = elementData.next;
        elementData.next = waitDeleted.next;
        waitDeleted.next = null;
        waitDeleted = null;
        currentSize--;
    }

    private void insertAtHead(T element) {
        head.next = new Node<T>(element, head.next);
        currentSize++;
    }

    private Node<T> findValueBefore(T element) {
        Node<T> temp = head;
        while (temp.next != null) {
            if (element.equals(temp.next.data)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    @Override
    public void printAll() {
        Node temp = head.next;

        while (temp != null) {
            System.out.print(temp.data.toString() + ",");
            temp = temp.next;
        }

        System.out.println();
    }

    private void deleteEnd() {
        Node data = head.next;

        if (data == null) {
            return;
        }
        while (data.next.next != null) {
            data = data.next;
        }
        Node temp = data.next;
        temp = null;
        data.next = null;
        currentSize--;
    }



    public static void main(String[] args) {
        LRUCacheLinkedList<Integer> data = new LRUCacheLinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            int value = sc.nextInt();
            if (value == -1) {
                data.printAll();
                break;
            }
            data.add(value);
            data.printAll();
        }
    }
}
