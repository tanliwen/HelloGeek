package sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static int[] sort(int[] datas) {
        if (datas == null || datas.length == 0) {
            return datas;
        }
        //4，           5，6，1，3，2
        //4， 5，       6，1，3，2
        //4， 5，  6，   1，3，2
        for(int i = 1; i < datas.length; i++) {
            int temp = datas[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (datas[j] > temp) {
                    datas[j + 1] = datas[j];
                } else {
                    break;
                }
            }
            datas[j + 1] = temp;
        }
        return datas;
    }
    
    public static void main(String[] args) {
        int[] datas = SortDataHelper.randomArray(10000);
        int[] newDatas = Arrays.copyOf(datas, datas.length);

        long time = System.currentTimeMillis();
        System.out.println(Arrays.toString(InsertSort.sort(datas)));
        System.out.println("insert:" + (System.currentTimeMillis() - time) + " ms");

        time = System.currentTimeMillis();
        System.out.println(Arrays.toString(BubbleSort.sort(newDatas)));
        System.out.println("bubble:" + (System.currentTimeMillis() - time) + " ms");
    }
}
