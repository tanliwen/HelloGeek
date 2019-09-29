package arrays;

class Solution53 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution53 solution = new Solution53();
        int[] datas = new int[]{-2, 1, -3, -1, 1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(datas));
    }
}