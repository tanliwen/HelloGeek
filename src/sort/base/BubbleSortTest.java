package sort.base;

import java.util.Arrays;

public class BubbleSortTest {

    //3, 2, 1, 4
    public static int[] sort(int[] datas) {
        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas.length - i - 1; j++) {
                if (datas[j] > datas[j + 1]) {
                    int temp = datas[j];
                    datas[j] = datas[j + 1];
                    datas[j + 1] = temp;
                }
            }
        }
        return datas;
    }

    public static void main(String[] args) {
        int[] datas = SortDataHelper.randomArray(100);
        int[] newDatas = Arrays.copyOf(datas, datas.length);

        System.out.println(Arrays.toString(datas));
        System.out.println(Arrays.toString(sort(datas)));

        Arrays.sort(newDatas);
        System.out.println(Arrays.toString(newDatas));

    }
}
