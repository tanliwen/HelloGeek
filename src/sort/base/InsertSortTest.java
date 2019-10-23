package sort.base;

import java.util.Arrays;

public class InsertSortTest {

    //3, 2, 1, 4
    public static int[] sort(int[] datas) {
        for (int i = 1; i < datas.length; i++) {
            int waitInsertData = datas[i];

            int j = i - 1;
            for (; j >= 0; j--) {
                if (waitInsertData < datas[j]) {
                    datas[j + 1] = datas[j];
                } else {
                    break;
                }
            }
            datas[j + 1] = waitInsertData;
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
