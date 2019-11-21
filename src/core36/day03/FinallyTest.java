package core36.day03;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Java finally
 * <p>
 * 1.try-with-resource 参考 https://www.cnblogs.com/itZhy/p/7636615.html (AutoCloseable)
 * 2.addSuppressed
 * 3.System.exit(1);
 */
public class FinallyTest {
    static void test1() {
        try {
            int a = 1;
        } finally {
            System.out.println("test1");
        }
    }

    static void test2() {
        try {
            int a = 1 / 0;
        } finally {
            System.out.println("test2");
        }
    }


    static void test3() {
        try {
            int a = 1 / 0;
        } catch (Throwable t) {
            System.out.println("test3 t = " + t.getMessage());
        } finally {
            System.out.println("test3 finally");
        }
    }

    static void test4() {
        try {
            System.exit(1);
        } finally {
            System.out.println("test4 finally");
        }
    }

    static void test5() {
        try (FileInputStream inputStream = new FileInputStream(new File("src/test.txt"))) {
            System.out.println(inputStream.read());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    public void read(String filename) throws IOException {
        FileInputStream input = null;
        IOException readException = null;
        try {
            input = new FileInputStream(filename);
        } catch (IOException ex) {
            readException = ex;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    if (readException != null) {
                        readException.addSuppressed(ex);
                    } else {
                        readException = ex;
                    }
                }
            }
            if (readException != null) {
                throw readException;
            }
        }
    }

    public static void test6() {
        Throwable throwable = null;
        try {
            int a = 1 / 0;
        } catch (Throwable t) {
            throwable = t;
            System.out.println("catch1 t = " + t.getMessage());
        } finally {
            try {
                int b = Integer.parseInt("aaaa");
            } catch (Throwable t2) {
                if (throwable != null) {
                    throwable.addSuppressed(t2);
                } else {
                    throwable = t2;
                }
                System.out.println("catch2 = " + t2.getMessage());
            }

            if (throwable != null) {
                Throwable[] list = throwable.getSuppressed();
                System.out.println("finally 1: " + throwable.getMessage());
                for (Throwable suppressedItem: list) {
                    System.out.println("finally 1:" + suppressedItem.getMessage());
                }
            }

        }
    }

    public static void main(String[] args) {
//        test4();
//        test5();
        test6();
    }
}
