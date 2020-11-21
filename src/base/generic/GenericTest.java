package base.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    static void  print(GenericType<? extends Fruit> f){
        System.out.println(f.data);
    }


    static void  print2(GenericType<? super Apple> f){
        System.out.println(f.data);
    }

    public static void main(String[] args) {
        GenericType<Fruit> a = new GenericType<>();
        GenericType<Orange> b = new GenericType<>();
        print(a);
        print(b);

        GenericType<? extends Fruit> c = b;

        Apple apple = new Apple();
        Orange orange = new Orange();

//        c.setData(apple);
//        c.setData(orange);
        System.out.println(c.getData());
    }

    public static void main2(String[] args) {
        List<? super Integer> s;
        s = new ArrayList<Number>();

//        Number n = s.get(0);  //语句错误

        Number a = new Integer(2);//语句错误
//        s.add(a);

        Integer b = new Integer(2); //语句正确
        s.add(b);
    }
}
