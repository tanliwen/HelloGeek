package core36.day04.weak;

import java.lang.ref.WeakReference;

/**
 * 弱引用
 */
public class WeakReferenceTest4 {
    public static void main(String[] args) {
        Object testObject = new Object();
        WeakReference<Object> refObject = new WeakReference<>(testObject);
        Object refObj = refObject.get();

        if (refObj == null) {
            System.out.println("refObj is null");
        } else {
            System.out.println("refObj is not null: " + refObj);
        }

        testObject = null;
//        refObj = null;
        System.gc();
        System.out.println(refObject.get());
    }
}
