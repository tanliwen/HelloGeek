package core36.day09;

import java.util.*;

/**
 * TreeMap
 * 实现了SortMap接口
 * 继承AbstractMap
 *
 * 排序默认升序
 * key需要实现Comparable接口，或者自定义 java.util.Comparator,
 *
 * 否则抛出异常 java.lang.ClassCastException key cannot be cast to class java.lang.Comparable
 */
public class TreeMapTest {

    static class Person{
        int age;
        int score;

        public Person(int age) {
            this.age = age;
        }

        public Person(int age, int score) {
            this.age = age;
            this.score = score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    score == person.score;
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, score);
        }
    }

    static void test1() {
        TreeMap<String, String> map = new TreeMap<>();

        map.put("2", "2");
        map.put("1", "1");


        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry: entrySet) {
            System.out.println("" + entry.getKey() + "," + entry.getValue());
        }
    }

    static void test2() {
        TreeMap<Person, String> map = new TreeMap<Person, String>(new Comparator<Person>() {
            //学生先按成绩由大到小排名，成绩相同时候按照年龄由低到高排序
            @Override
            public int compare(Person o1, Person o2) {
//                return 1; //降序
//                return -1; //升序

                if (o2.score > o1.score) {
                    return 1;
                } else if(o2.score < o1.score) {
                    return -1;
                } else {
                    if (o2.age > o1.age) {
                        return -1;
                    } else if (o2.age < o1.age) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        map.put(new Person(18, 60), "user1");
        map.put(new Person(16, 50), "user2");
        map.put(new Person(16, 80), "user3");
        map.put(new Person(17, 80), "user4");
        map.put(new Person(17, 90), "user4");



        Set<Map.Entry<Person, String>> entrySet = map.entrySet();
        for (Map.Entry<Person, String> entry: entrySet) {
            System.out.println(entry.getValue()+ "," + entry.getKey().score + "," + entry.getKey().age);
        }
    }
    public static void main(String[] args) {
        test2();
    }
}
