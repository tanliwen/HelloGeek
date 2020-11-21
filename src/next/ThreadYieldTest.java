package next;

import framework.L;

public class ThreadYieldTest {
    static Thread firstThread;
    static Thread secondThread;

    public static class FirstThread extends Thread {
        @Override
        public void run() {
            int i = 20;

            while (i > 0) {
                L.d("I am name =  " + Thread.currentThread().getClass().getSimpleName() + ", i = " + i);
                i--;
                try {
                    Thread.sleep(1000);
                    if (i == 15) {
                        //让出执行权，让出后，可能会被重新选中
                        yield();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class SecondThread extends Thread {
        @Override
        public void run() {
            int i = 100;
            while (i > 0) {
                L.d("I am name =  " + Thread.currentThread().getClass().getSimpleName() + ", i = " + i);
                i--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        firstThread = new FirstThread();
        secondThread = new SecondThread();
        firstThread.start();
        secondThread.start();
    }
}
