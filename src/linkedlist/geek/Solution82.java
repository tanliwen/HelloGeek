package linkedlist.geek;

import java.util.Stack;

public class Solution82 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
         //slow
       //newHead    fast
                 //  1 ->  1   ->  2  ->  2 -> 3

                         //slow              fast
                //  1 ->   2    ->   3   ->    3   ->     4  -> 4 -> 5


                            //slow                        fast
                  //  1 ->   2        3   ->     3   ->     4  -> 4 -> 5
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode slow = newHead;
        ListNode fast = newHead.next;

        while (fast != null && fast.next != null) {
            if (slow.next.val != fast.next.val) {
                slow = slow.next;
                fast = fast.next;
            } else {
                while (fast != null && fast.next != null && slow.next.val == fast.next.val){
                    fast = fast.next;
                }
                slow.next = fast.next;
                fast = fast.next;
            }
        }
        return newHead.next;
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
        Solution82 solution = new Solution82();
    }

}
