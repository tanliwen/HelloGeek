package ks.test1;

/**
 * Int to String
 * int + "'
 * String.valueOf()         内部调用了Integer.toString
 * Integer.toString(int)
 */
public class Test01 {
    static final boolean COMPACT_STRINGS = true;

    static final byte[] DigitOnes = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57};
    static final byte[] DigitTens = new byte[]{48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 56, 56, 56, 56, 56, 56, 56, 56, 56, 56, 57, 57, 57, 57, 57, 57, 57, 57, 57, 57};

    static int stringSize(int x) {
        int d = 1;
        if (x >= 0) {
            d = 0;
            x = -x;
        }

        int p = -10;

        for(int i = 1; i < 10; ++i) {
            if (x > p) {
                return i + d;
            }

            p = 10 * p;
        }

        return 10 + d;
    }

    static int getChars(int i, int index, byte[] buf) {
        int charPos = index;
        boolean negative = i < 0;
        if (!negative) {
            i = -i;
        }

        int q;
        int r;
        while(i <= -100) {
            q = i / 100;
            r = q * 100 - i;
            i = q;
            --charPos;
            buf[charPos] = DigitOnes[r];
            --charPos;
            buf[charPos] = DigitTens[r];
        }

        q = i / 10;
        r = q * 10 - i;
        --charPos;
        buf[charPos] = (byte)(48 + r);
        if (q < 0) {
            --charPos;
            buf[charPos] = (byte)(48 - q);
        }

        if (negative) {
            --charPos;
            buf[charPos] = 45;
        }

        return charPos;
    }

    public static String toString(int i) {
        int size = stringSize(i);
        byte[] buf;
        if (Test01.COMPACT_STRINGS) {
            buf = new byte[size];
            getChars(i, size, buf);
            return new String(buf, (byte)0);
        }
        return "error";
    }

    public static void main(String[] args) {
        String a = 10 + "";
        String b = String.valueOf(10);

        System.out.println("MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("stringSize: " + stringSize(123456789));
        System.out.println("stringSize: " + stringSize(Integer.MAX_VALUE ));
        System.out.println("valueOf: " + toString(Integer.MAX_VALUE));

    }
}
