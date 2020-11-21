package linkedlist.geek;

import java.util.HashSet;
import java.util.Set;

public class SolutionDetectCycle {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        Set<ListNode> history = new HashSet<>();
        ListNode pointerHead = head;
        while(pointerHead != null) {
            if(history.contains(pointerHead)) {
                return pointerHead;
            } else {
                history.add(pointerHead);
                pointerHead = pointerHead.next;
            }
        }
        return null;
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
        SolutionDetectCycle solution = new SolutionDetectCycle();
    }

}
