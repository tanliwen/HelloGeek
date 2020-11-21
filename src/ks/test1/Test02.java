package ks.test1;

/**
 * Int to String
 * int + "'
 * String.valueOf()         内部调用了Integer.toString
 * Integer.toString(int)
 */
public class Test02 {
    public static void main(String[] args) {
        String a = 10 + "";
        System.out.println(a);
    }
}
