package linkedlist.geek;


class Solution206 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode addBeforeHead(ListNode head, ListNode newNode) {
        if (newNode == null) {
            return null;
        }

        if (head == null) {
            return newNode;
        }

        newNode.next = head;

        return newNode;
    }

    public void deletedEnd(ListNode head) {
        ListNode temp = head;

        if (temp == null) {
            return;
        }
        //1, 2, -1
        while (temp.next.next != null) {
            temp = temp.next;
        }
        ListNode removed = temp.next;
        removed.next = null;
        removed = null;
        temp.next = null;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(-1);

        ListNode temp = head;

        while (temp != null) {
            newHead = addBeforeHead(newHead, new ListNode(temp.val));
            temp = temp.next;
        }
        deletedEnd(newHead);
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        //1 -> 2 - > 3 -> null
        //null <- 1 <- 2 <- 3

        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }


    public ListNode reverseList3(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {// 1, 2 ,3
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
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
        Solution206 solution = new Solution206();
        ListNode head = new ListNode(1);
        ListNode test1 = new ListNode(2);
        ListNode test2 = new ListNode(-1);
        head.next = test1;
        test1.next = test2;
        test2.next = null;
        solution.printAll(head);

        solution.printAll(solution.reverseList3(head));
    }
}