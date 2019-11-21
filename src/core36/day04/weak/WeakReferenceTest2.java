package core36.day04.weak;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * 弱引用
 */
public class WeakReferenceTest2 {

    static class A {
        private WeakReference<B> b;
        public A(B b) {
            this.b = new WeakReference<>(b);
        }

        public B getB() {
            if (b != null) {
                return b.get();
            } else {
                return null;
            }
        }
    }

    static class C {
        private B b;
        public C(B b) {
            this.b = b;
        }

        public B getB() {
            return b;
        }
    }

    static class B{
        public B() {

        }
    }

    public static void main(String[] args) {
        B b = new B();
        A a = new A(b);
        C c = new C(b);

        b = null;
        System.gc();
        System.out.println(a.getB());
        System.out.println(c.getB());
    }
}
