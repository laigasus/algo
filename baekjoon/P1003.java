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

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }
}