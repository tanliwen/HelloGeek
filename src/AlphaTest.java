import linkedlist.geek.Solution203;

import java.util.HashSet;
import java.util.Set;

public class AlphaTest {
    public static void main(String[] args) {

        for(int i = 0; i <= 100; i++) {
            int value = i;
            int alpha = value;
            int target = (int) (255 * alpha / 100f);
            System.out.println("target = " + i + ", hex = " + Integer.toHexString(target));
        }

    }


    public int binearySearch(int[] nums, int target){
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left  + (right - left ) >> 2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }

        for(int i = 0; i < matrix.length; i++){
            if(binearySearch(matrix[i], target) != -1) {
                return true;
            }
        }
        return false;
    }
}
