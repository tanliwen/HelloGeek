package sort;

import java.util.ArrayList;
import java.util.Arrays;

class Solution349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        if (nums1.length == 0 || nums2.length == 0) {
            return null;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

        int min = Math.min(nums1.length, nums2.length);

        ArrayList<Integer> data = new ArrayList<>(min);

        for (int i = 0; i < min; i++) {
            if (nums1[i] == nums2[i]) {
                data.add(nums1[i]);
            } else {
                break;
            }
        }

        if (data.size() == 0) {
            return null;
        } else {
            int[] returnData = new int[data.size()];
            for (int j = 0; j < data.size(); j++) {
                returnData[j] = data.get(j);
            }
            return returnData;
        }
    }

    public static void main(String[] args) {
        Solution349 solution = new Solution349();
        System.out.println(Arrays.toString(solution.intersection(new int[]{1,2,2,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(solution.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }
}