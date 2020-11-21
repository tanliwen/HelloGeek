package base;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(String.valueOf(1));
    }
}