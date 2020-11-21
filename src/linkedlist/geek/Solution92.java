package linkedlist.geek;

public class Solution92 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    // 1   ->  2   ->    3      ->    4      ->       5
    public ListNode reverseBetween(ListNode head, int m, int n) {
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
        Solution92 solution = new Solution92();
    }

}
