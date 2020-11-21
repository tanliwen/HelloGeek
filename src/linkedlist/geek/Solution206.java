package linkedlist.geek;

import java.util.*;

public class Solution206 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //current  next       flag
    //1     ->  2        ->       3       ->         4

    //current      next
    //null <-  1     ->    2        ->       3       ->         4

    //current          next
    //null <-  1     <-     2         ->      3

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = null;
        ListNode next = head;
        while (next.next != null) {
            ListNode flag = next.next;
            next.next = current;
            current = next;
            next = flag;
        }
        next.next = current;
        return next;
    }

    void printAll(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.println();
    }


    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = null;
        ListNode next = head.next;

        while (next != null) {
            ListNode nextNext = next.next;
            if (nextNext == null) {
                break;
            } else {
                next.next = current;
                current = next;
                next = nextNext;
            }
        }
        next.next = current;
        return next;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode reverseHead = reverse(head);
        ListNode newHead = reverseHead;
        int index = 1;
        while (reverseHead != null) {
            if (index == k) {
                reverseHead.next = null;
                return reverse(newHead);
            } else {
                index++;
                reverseHead = reverseHead.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution206 solution = new Solution206();
        ListNode head = new ListNode(1);
        ListNode test1 = new ListNode(2);
        ListNode test2 = new ListNode(3);
        ListNode test3 = new ListNode(4);
        head.next = test1;
        test1.next = test2;
        test2.next = test3;
        test3.next = null;
        solution.printAll(head);

        solution.printAll(solution.reverse(head));
    }

    private int[] mapToArrays(Set<Integer> set) {
        if (set.size() == 0) {
            return null;
        }
        int[] array = new int[set.size()];
        int index = 0;
        for (int value : set) {
            array[index++] = value;
        }
        return array;
    }

    // 1 2 2 1
    // 2
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        if (nums1.length < nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        Set<Integer> set = new HashSet<>(nums1.length);
        for (int value : nums1) {
            set.add(value);
        }

        Set<Integer> result = new HashSet<>(nums2.length);
        for (int current : nums2) {
            if (set.contains(current)) {
                result.add(current);
            }
        }
//        return  result.stream().mapToInt(Integer::intValue).toArray();
        return mapToArrays(result);
    }
}
