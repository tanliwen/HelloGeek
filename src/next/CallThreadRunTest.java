package next;

import framework.L;

public class CallThreadRunTest {
    public static class ExtendThread extends Thread {


        @Override
        public void run() {
            int i = 10;

            while (i > 0) {
                L.d("I am ExtendThread name =  " + Thread.currentThread().getName() + ", i = " + i);
                i--;
            }
        }
    }
    public static void main(String[] args) {
        Thread thread = new ExtendThread();
        thread.setName("ExtendThreadSelfName");

        thread.run();
        thread.start();
    }
}
