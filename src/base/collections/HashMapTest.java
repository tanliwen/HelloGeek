package base.collections;

import java.util.HashMap;
import java.util.Hashtable;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put(null, 2);
        map.put(null, 3);


        System.out.println(map.get(null));

        Hashtable<String, Integer> table = new Hashtable<>();
    }
}
