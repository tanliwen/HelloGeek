package sort.base;

import java.util.Arrays;

public class SelectSortTest {

    //1, 2, 3, 4
    public static int[] sort(int[] datas) {
        for (int i = 0; i < datas.length; i++) {

            int minIndex = i;

            for (int j = i + 1; j < datas.length; j++) {
                if (datas[j] < datas[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = datas[i];
                datas[i] = datas[minIndex];
                datas[minIndex] = temp;
            }
        }
        return datas;
    }

    public static void main(String[] args) {
        int[] datas = SortDataHelper.randomArray(10);
        int[] newDatas = Arrays.copyOf(datas, datas.length);

        System.out.println(Arrays.toString(datas));
        System.out.println(Arrays.toString(sort(datas)));

        Arrays.sort(newDatas);
        System.out.println(Arrays.toString(newDatas));

    }
}
