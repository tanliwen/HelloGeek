package arrays;

//https://leetcode-cn.com/problems/remove-element/
class Solution27 {

    private int removeElement(int[] nums, int val) {

        int newLength = nums.length;

        for (int i = 0; i < newLength; ) {
            int index = i;
            if (nums[index] != val) {
                i++;
            } else {
                for (int j = index + 1; j < newLength; j++) {
                    nums[j - 1] = nums[j];
                }
                newLength--;
            }
        }
        return newLength;
    }

    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int len = solution27.removeElement(nums, 3);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}