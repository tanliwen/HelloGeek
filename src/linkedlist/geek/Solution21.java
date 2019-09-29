package linkedlist.geek;


import java.util.HashSet;

class Solution21 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insert(ListNode head, ListNode target) {
        if (head == null || target == null) {
            return null;
        }
        ListNode current = head;
        //1,1,3,4] [5
        //i
        while (current != null) {
            if (current.val > target.val) {
                target.next = current;
                return target;
            } else {
                if (current.next == null) {
                    current.next = target;
                    return head;
                } else {
                    if (current.next.val >= target.val) {
                        target.next = current.next;
                        current.next = target;
                        return head;
                    }
                }
            }
            current = current.next;
        }
        return null;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        HashSet<ListNode> node = new HashSet<>();

        ListNode head2 = l2;

        while (head2 != null) {
            ListNode temp = insert(l1, new ListNode(head2.val));
            if (temp != l1 && temp != null) {
                l1 = temp;
            }
            head2 = head2.next;
        }

        return l1;
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
        Solution21 solution = new Solution21();
        ListNode head = new ListNode(2);
//        ListNode test1 = new ListNode(2);
//        ListNode test2 = new ListNode(3);
//        ListNode test3 = new ListNode(4);
//        head.next = test1;
//        test1.next = test2;
//        test2.next = test3;

        ListNode head2 = new ListNode(1);
//        ListNode test4 = new ListNode(5);
//        head2.next = test4;

        solution.printAll(solution.mergeTwoLists(head, head2));
    }
}