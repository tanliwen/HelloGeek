package core36.day04.weak;

import java.lang.ref.WeakReference;

/**
 * 弱引用
 */
public class WeakReferenceTest1 {

    private boolean isRunning = true;
    private int count = 0;
    private int maxCount = 3;

    public static void main(String[] args) {
        WeakReferenceTest1 test = new WeakReferenceTest1();
        final Object[] testObjects = {new Object()};
        WeakReference<Object> refObject = new WeakReference<>(testObjects[0]);
        new Thread() {
            public void run() {
                while (test.isRunning) {
                    if (refObject.get() == null) {
                        System.out.println("refObj is null");
                        test.isRunning = false;
                    } else {
                        System.out.println("refObj is not null: " + refObject.get());
                    }

                    test.count++;
                    if (test.count == test.maxCount) {
                        System.out.println("set refObj to null");
                        testObjects[0] = null;
                        System.gc();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
    }
}
