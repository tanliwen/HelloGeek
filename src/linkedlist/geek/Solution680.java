package linkedlist.geek;

public class Solution680 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(String s) {
        char[] values = s.toCharArray();
        int start = 0;
        int end = values.length - 1;
        while (start <= end) {
            if (values[start] == values[end]) {
                start++;
                end--;
            } else {
                //删除左边
                boolean flag = true;
                for (int i = start + 1, j = end ; i < j; i++, j--) {
                    if (values[i] != values[j]) {
                        flag = false;
                        break;
                    }
                }

                //删除右边
                boolean flag2 = true;

                for (int i = start, j = end - 1; i < j; i++, j--) {
                    if (values[i] != values[j]) {
                        flag2 = false;
                        break;
                    }
                }
                return flag || flag2;
            }
        }
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
        Solution680 solution = new Solution680();
    }

}
