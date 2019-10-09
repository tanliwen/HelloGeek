package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static int[] sort(int[] datas) {
        if (datas == null || datas.length == 0) {
            return datas;
        }
        //5,1,3,5
        for(int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas.length - i - 1; j++) {
                if (datas[j + 1] < datas[j]) {
                    int temp = datas[j];
                    datas[j] = datas[j + 1];
                    datas[j + 1] = temp;
                }
            }
        }
        return datas;
    }

    public static void main(String[] args) {
        int[] datas = SortDataHelper.randomArray(100000);
        long time = System.currentTimeMillis();
        System.out.println(Arrays.toString(BubbleSort.sort(datas)));
        System.out.println(System.currentTimeMillis() - time + " ms");
    }
}
