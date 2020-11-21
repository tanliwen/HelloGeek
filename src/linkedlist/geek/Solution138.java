package linkedlist.geek;

public class Solution138 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

     //  random = 1
    //   0       ->      1    ->   2 -> 3
    public Node copyRandomList(Node head) {

        return head;
    }
    public static void main(String[] args) {
        Solution138 solution = new Solution138();
    }

}
