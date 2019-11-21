package core36.day03;

import java.lang.ref.Cleaner;

/**
 * Java Cleaner
 */
public class CleanerTest implements AutoCloseable{
    private final State state;
    private final Cleaner  cleaner = Cleaner.create();
    private final Cleaner.Cleanable  cleanable;


    public CleanerTest() {
        this.state = new State();
        cleanable = cleaner.register(this, state);
    }

    static class State implements  Runnable {

        @Override
        public void run() {
            System.out.println("State");
        }
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }

    public static void main(String[] args) {
        CleanerTest test = new CleanerTest();
        try {
            test.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
