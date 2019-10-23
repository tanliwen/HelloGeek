package sort.base;

/**
 * 待排序数据模拟生成
 */
public class SortDataHelper {
    public static int[] randomArray(int n) {
        int[] datas = new int[n];

        int min = 1;
        for (int i = 0; i < n; i++) {
            int data = (int) (Math.random()*(n-min)+min);
            datas[i] = data;
        }
        return datas;
    }
}
