package base.collections;

import sort.base.SortDataHelper;

import java.util.*;

public class LinkedHashMapTest {

    static int[] sData = SortDataHelper.randomArray(10);

    private static void initMap(int[] data) {
        long time = System.currentTimeMillis();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < data.length; i++) {
            map.put(data[i], i);
        }
        System.out.println("init cost time:" + (System.currentTimeMillis() - time) + " ms");
    }

    private static void initMap2(int[] data) {
        long time = System.currentTimeMillis();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(data.length);
        for (int i = 0; i < data.length; i++) {
            map.put(data[i], i);
        }
        System.out.println("init map cost time:" + (System.currentTimeMillis() - time) + " ms");
    }
    private static void initMap3() {
        long time = System.currentTimeMillis();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(10, 0.75f, true);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

//        map.get(2);
        map.get(2);
        map.get(1);

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }

        System.out.println("init map cost time:" + (System.currentTimeMillis() - time) + " ms");
    }
    private static void initMap4() {
        long time = System.currentTimeMillis();
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(16, 0.75f, true);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");

        map.get("2");


        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
    }

    public static void main(String[] args) {
//        initMap(sData);
//        initMap2(sData);
        initMap3();
//        initMap4();
    }
}
