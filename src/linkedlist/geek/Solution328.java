package linkedlist.geek;

public class Solution328 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    void printAll(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.println();
    }

      //tempHead
       //-1      ->    2  -> null
               //pointerHead
                            //fastNext
                 //fast
     // slow
    // 1       ->   2    ->       3        ->    4    ->    5
    //奇数         偶数           奇数            偶数       奇数

                                                              //fast
                                                       // slow
     // 1       ->   2    ->       3        ->    4    ->    5
     //奇数         偶数           奇数            偶数       奇数

                                                                    //fast
                                                         //slow
    // 1       ->   2    ->       3        ->    4    ->    5   - >    6
    //奇数         偶数           奇数            偶数       奇数         偶数

    // 1 -> 3 -> 2 -> 4 -> 5- > 6
     public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode tempHead = new ListNode(-1);
        ListNode pointerHead = tempHead;
        while (fast != null) {
            ListNode fastNext = fast.next;
            if (fastNext == null) {
                break;
            }

            slow.next = fast.next;
            fast.next = null;
            pointerHead.next = fast;
            pointerHead = fast;

            slow = slow.next;
            fast = fastNext.next;
        }

        if (tempHead.next != null) {
            if (fast != null) {
                slow.next = tempHead.next;
                pointerHead.next = fast;
            } else {
                slow.next = tempHead.next;
            }
        }

        return head;
     }

    public static void main(String[] args) {
        Solution328 solution = new Solution328();
    }

}
