package next;

import framework.L;

public class ThreadInterruptExceptionTest {

    public static class ExtendThread extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    //isInterrupted 会被改成false
                    e.printStackTrace();
                }
                L.d("I am inner is " + isInterrupted());
            }

            L.d("I am end is " + isInterrupted());
        }
    }

    public static void main(String[] args) {
        Thread thread = new ExtendThread();
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
