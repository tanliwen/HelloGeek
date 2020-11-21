package linkedlist.geek;

import java.util.Set;
import java.util.Stack;

public class Solution234 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 3
    // 2
    // 1
    //1-2-3 O(n)
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> origin = new Stack<>();
        ListNode tempHead = head;

        while (tempHead != null) {
            origin.push(tempHead.val);
            tempHead = tempHead.next;
        }

        tempHead = head;

        while (tempHead != null) {
            if (tempHead.val != origin.pop()) {
                return false;
            }
            tempHead = tempHead.next;
        }

        return true;
    }

    // 1 -> 2 -> 3 -> 3 -> 2 -> 1

    // 1 -> 2 -> 3 -> 3 <- 2 <- 1

    public boolean isPalindrome2(ListNode head) {

        return true;
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
        Solution234 solution = new Solution234();
    }

}
