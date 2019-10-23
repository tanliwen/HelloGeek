package sort;

import java.util.*;

class Solution242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] data1 = s.toCharArray();
        char[] data2 = t.toCharArray();
        Arrays.sort(data1);
        Arrays.sort(data2);
        return Arrays.equals(data1, data2);
    }

    public static void main(String[] args) {
        Solution242 solution = new Solution242();
    }
}