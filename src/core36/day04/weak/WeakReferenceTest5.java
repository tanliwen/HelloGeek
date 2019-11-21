package core36.day04.weak;

import java.lang.ref.WeakReference;

/**
 * 弱引用
 */
public class WeakReferenceTest5 {
    public static void main(String[] args) {
        WeakReference<Object> refObject = new WeakReference<>(new Object());
        System.out.println(refObject.get());
        System.gc();
        System.out.println(refObject.get());
    }
}
