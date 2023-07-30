import java.io.IOException;

public class P1003 {
    static int zero;
    static int one;
    static int zeroPlusOne;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int T = readInt();

        while (T-- > 0) {
            int N = readInt();
            fibonacci(N);
            sb.append(zero).append(' ').append(one).append('\n');
        }
        
        System.out.print(sb);
    }

    public static void fibonacci(int N) {
        zero = 1;
        one = 0;
        zeroPlusOne = 1;

        while (N-- > 0) {
            zero = one;
            one = zeroPlusOne;
            zeroPlusOne = zero + one;
        }
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