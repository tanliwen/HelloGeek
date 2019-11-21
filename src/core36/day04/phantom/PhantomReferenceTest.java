package core36.day04.phantom;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚幻引用
 * https://www.ibm.com/developerworks/cn/java/j-lo-langref/index.html
 *
 */
public class PhantomReferenceTest {

    static void test1() {
        ReferenceQueue<String> refQueue = new ReferenceQueue<String>();
        PhantomReference<String> referent = new PhantomReference<String>(new String("T"), refQueue);

        System.out.println(referent.get());// null

        System.gc();
        System.runFinalization();

        System.out.println(refQueue.poll() == referent); //true
    }

    static class A{
       /* protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize A");   //加入打印，结果不一样
        }*/
    }

    static void test2() {
        ReferenceQueue<A> refQueue = new ReferenceQueue<A>();
        PhantomReference<A> referent = new PhantomReference<A>(new A(), refQueue);

        System.out.println(referent.get());// null

        System.gc();
        System.runFinalization();

        try {
            System.out.println(refQueue.remove() == referent); //true
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }
}
