package arrays;

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int index = 0;

        for ( int i = 0; i < nums.length; i++) {
            if (nums[i] == target || target < nums[i]) {
                index = i;
                break;
            } else {
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        int[] nums = new int[]{1,3,5,6};
//        int[] nums = new int[]{1};
        System.out.println(solution35.searchInsert(nums, 7));
    }
}