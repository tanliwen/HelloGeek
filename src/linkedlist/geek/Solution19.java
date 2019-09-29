package linkedlist.geek;

import java.util.ArrayList;

class Solution19 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //1,2,  1
        ArrayList<ListNode> datas = new ArrayList<>();

        ListNode temp = head;
        while (temp != null) {
            datas.add(temp);
            temp = temp.next;
        }

        int index = datas.size() - n;

        if (index < 0) {
            return head;
        }

        int prev = datas.size() - n - 1;

        if (prev < 0) {
            if (datas.size() >= 2) {
                return datas.get(1);
            } else {
                return null;
            }
        } else {
            ListNode prevNode = datas.get(prev);
            ListNode byRemoved = datas.get(index);
            prevNode.next = byRemoved.next;
            byRemoved.next = null;
            byRemoved = null;
        }
        datas.clear();
        return head;
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
        Solution19 solution = new Solution19();
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
//        ListNode next2 = new ListNode(3);
//        ListNode next3 = new ListNode(4);

        head.next = next1;
//        next1.next = next2;
//        next2.next = next3;

        solution.printAll(solution.removeNthFromEnd(head,2));
    }
}