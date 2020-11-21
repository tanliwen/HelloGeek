package linkedlist.geek;

public class Solution203 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
                //newHead
    //-1          1,  2, 3,4, 5,6
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode tempHead = fakeHead;

        ListNode waitDelete;

        while ((waitDelete = tempHead.next) != null) {
            if (waitDelete.val == val){
                tempHead.next = waitDelete.next;
            } else {
                tempHead = tempHead.next;
            }
        }
        return fakeHead.next;
    }

    void printAll(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Solution203 solution = new Solution203();

        solution.printAll(node1);
        solution.printAll(solution.removeElements(node1, 1));
    }

}
