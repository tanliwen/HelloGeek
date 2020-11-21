package next;

import framework.L;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCreateTest {

    public static class ExtendThread extends Thread {
        @Override
        public void run() {
            L.d("I am ExtendThread");
        }
    }

    public static class ImplRunnable implements Runnable {
        @Override
        public void run() {
            L.d("I am runnable");
        }
    }

    private static class ImplCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(5000);
            return "I am callable";
        }
    }

    public static void main(String[] args) {

        new ExtendThread().start();

        new Thread(new ImplRunnable()).start();

        ImplCallable callable = new ImplCallable();

        FutureTask<String> futureTask = new FutureTask<>(callable);

        new Thread(futureTask).start();

        try {
            L.d("before exc get");
            L.d(futureTask.get());
            L.d("after exc get");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
