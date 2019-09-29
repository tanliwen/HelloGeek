package linkedlist.geek;


import java.util.HashSet;

class Solution141 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    //1,2,3
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head)) {
                return true;
            } else {
                nodes.add(head);
            }
            head = head.next;
        }
        return false;
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
        Solution141 solution = new Solution141();
        ListNode head = new ListNode(1);
        ListNode test1 = new ListNode(2);
        ListNode test2 = new ListNode(3);
        ListNode test3 = new ListNode(4);
        head.next = test1;
        test1.next = test2;
        test2.next = test3;
//        test3.next = test2;
//        solution.printAll(head);
        System.out.println(solution.hasCycle(head));
    }
}