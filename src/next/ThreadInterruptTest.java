package next;

import framework.L;

public class ThreadInterruptTest {

    public static class ExtendThread extends Thread {
        @Override
        public void run() {
            L.d("I am ExtendThread before is " + isInterrupted());
//            while (true) {
//            while (!Thread.interrupted()) {
            while (!isInterrupted()) {
//                L.d("I am ExtendThread");
                L.d("I am ExtendThread inner is " + isInterrupted());
            }
            L.d("I am ExtendThread end is " + isInterrupted());
        }
    }

    public static void main(String[] args) {
        Thread thread = new ExtendThread();
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
