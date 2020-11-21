package core36.day09;

import java.util.HashMap;

/**
 * HashMap
 *
 * 1.负载因子，初始容量, 扩容机制
 * 2.什么是hash 冲突，如何解决？
 * 3.底层结构
 * 4.是为支持null值/value?
 *https://www.cnblogs.com/xiarongjin/p/8310691.html

 https://blog.csdn.net/liuqiyao_01/article/details/14475159

 * 开放地址法
 * 链地址法
 */
public class HashMapTest {

    static void test() {
        int hashCode = 1000;
        int h;

        int index  = (h = hashCode) ^ h >>> 16;
        System.out.print(index);
    }

    static void test2() {
        HashMap<Object, String> map = new HashMap<>();

        ClassA a = new ClassA("key");

        ClassB b = new ClassB("key");

        map.put(a, "1");
//        map.put(b, "2");
//        System.out.println(map.get(a));
//        System.out.println(map.get(b));
    }

    public static void main(String[] args) {
        test();
    }
}
