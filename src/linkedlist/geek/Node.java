package linkedlist.geek;

public class Node<T> {
    public Node<T> next;
    public T data;

    public Node() {
        this.next = null;
    }

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
}