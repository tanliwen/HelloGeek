package arrays;

import java.math.BigInteger;
import java.util.Arrays;

class Solution66 {
    int[] increaseArray(int[] origin) {
        int[] newNums = new int[origin.length + 1];
        newNums[0] = 1;
       /*
        for (int i = 0; i < origin.length; i++) {
            newNums[i + 1] = origin[i];
        }*/
        return newNums;
    }

    public int[] plusOne(int[] digits) {
        int ahead = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + ahead;
            if (sum < 10) {
                digits[i] = sum;
                ahead = 0;
                break;
            } else {
                digits[i] = 0;
                ahead = 1;
            }
        }
        if (ahead == 1) {
            return increaseArray(digits);
        }
        return digits;
    }

    public static void main(String[] args) {
        Solution66 solution = new Solution66();
//        int[] nums = new int[]{1, 9, 9, 9};
//        int[] nums = new int[]{1, 0, 0, 0};
        int[] nums = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1, 1, 2, 3, 9};
//        int[] nums = new int[]{9, 9, 9};
        int[] newNums = solution.plusOne(nums);

        System.out.println(Arrays.toString(newNums));
    }
}