package jvm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SuperClass {
    static {
        System.out.println("SuperClass init");
    }

    public static final int value = 1000;

    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        String[] contents = s.split(" ");
        if (contents.length > 0) {
            StringBuilder sb = new StringBuilder(s.length());
            for (String content : contents) {
                for (int j = content.length() - 1; j >= 0; j--) {
                    char value = content.charAt(j);
                    sb.append(value);
                }
                sb.append(" ");
            }
            return sb.toString();
        } else {
            return s;
        }
    }

    public int singleNumber(int[] nums) {
        List<Integer> historyList = new LinkedList<>();
        for (Integer num : nums) {
            if (!historyList.contains(num)) {
                historyList.add(num);
            } else {
                historyList.remove(num);
            }
        }
        int a = 100;
        String.valueOf(a).toCharArray();
        return historyList.get(0);
    }
}
