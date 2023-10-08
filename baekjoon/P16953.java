import java.io.IOException;

public class P16953 {
    static final int MAX = 1_000_000_000;
    static long B;

    public static void main(String[] args) throws IOException {
        long A = readInt();
        B = readInt();

        calc(A, 1);
        System.out.println(-1);
    }

    private static void calc(long A, long cnt) {
        if (A == B) {
            System.out.println(cnt);
            System.exit(0);
        } else if (A > B || A > MAX) {
            return;
        }
        calc(A * 2, cnt + 1);
        calc(A * 10 + 1, cnt + 1);
    }

    private static int readInt() throws IOException {
        int rs = 0;
        boolean isNegative = false;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        if (c == '-') {
            isNegative = true;
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return isNegative ? -rs : rs;
    }
}