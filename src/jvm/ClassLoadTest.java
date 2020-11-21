package jvm;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ClassLoadTest {

    class ItemBean{
        long orderTime;
        long orderValue;
    }
    public static void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int[] countArray = new int[]{0, 0, 0};
        for(int i = 0; i < nums.length; i++){
            countArray[nums[i]] = countArray[nums[i]] + 1;
        }

        System.out.println(Arrays.toString(countArray));

        int index = 0;
        for(int j = 0; j < countArray.length; j++){
            for(int k = 0; k < countArray[j]; k++) {
                nums[index] = j;
                index++;
            }
        }
    }

    //arr 0,1,2,3,4,5,6,7,8
    public static int[] sortByBits(int[] arr) {
        int[] map = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            map[i] = Integer.bitCount(arr[i]) * 100000 + arr[i];
        }
        System.out.println("map before: " + Arrays.toString(map));
        Arrays.sort(map);
        System.out.println("map result: " + Arrays.toString(map));

        for (int i = 0; i < map.length; i++) {
            map[i] = map[i] % 100000;
        }
        return map;
    }

    public static void main(String[] args) {

  /*      int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));*/


        int[] nums2 = new int[]{0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(sortByBits(nums2)));


//        System.out.println(SuperClass.value);
    }
}
