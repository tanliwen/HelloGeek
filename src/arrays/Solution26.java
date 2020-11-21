package arrays;

class Solution26 {

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    private int removeDuplicates(int[] nums) {
        int newLength = nums.length;
        if (nums.length > 1) {
            for (int i = 1; i < newLength; ) {
                if (nums[i] == nums[i - 1]) {
                    int startIndex = i - 1;
                    int endIndex = i;
                    for (int j = endIndex; j < newLength; j++) {
                        if (nums[startIndex] == nums[j]) {
                            endIndex = j;
                        } else {
                            break;
                        }
                    }
                    int diff = endIndex - startIndex;
                    for (int k = startIndex; k + diff < newLength; k++) {
                        nums[k] = nums[diff + k];
                    }
                    newLength = newLength - diff;

                } else {
                    i++;
                }
            }
        }
        return newLength;
    }

    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int[] nums = new int[]{0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 4, 5, 5};
//        int[] nums = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 0, 0};
//        var len = solution26.removeDuplicates(nums);
        int len = solution26.removeDuplicates2(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}