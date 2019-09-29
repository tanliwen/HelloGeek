package linkedlist.geek;


import java.util.ArrayList;

class Solution876 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    void printAll(Solution876.ListNode head) {
        Solution876.ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.println();
    }

    //1,2,3,4
    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            nodes.add(temp);
            temp = temp.next;
        }

        int len = nodes.size();

        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return nodes.get(0);
        }

        int i = len / 2;

        ListNode middleNode = nodes.get(i);
        nodes.clear();
        return middleNode;
    }

    //快慢指针法
    //1, 2, -1
    //  slow
    //     fast
    public ListNode middleNode2(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public static void main(String[] args) {
        Solution876 solution = new Solution876();
        ListNode head = new ListNode(1);
        ListNode test1 = new ListNode(2);
        ListNode test2 = new ListNode(3);
        ListNode test3 = new ListNode(4);
        head.next = test1;
        test1.next = test2;
        test2.next = test3;
        test3.next = null;
        solution.printAll(head);
//        solution.printAll(solution.middleNode(head));
        solution.printAll(solution.middleNode2(head));
    }
}