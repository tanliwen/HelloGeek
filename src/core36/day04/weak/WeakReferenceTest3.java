package core36.day04.weak;

import java.lang.ref.WeakReference;

/**
 * 弱引用
 */
public class WeakReferenceTest3 {

    public static void main(String[] args) {
        WeakReferenceTest3 test = new WeakReferenceTest3();
        final Object[] testObjects = {new Object()};
        WeakReference<Object> refObject = new WeakReference<>(testObjects[0]);
        testObjects[0] = null;
        System.gc();
        System.out.println(refObject.get());

    }
}
