import java.io.IOException;

public class P9372 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();

        while (T-- > 0) {
            int N = readInt();
            int M = readInt();
            init(N, M);
            sb.append(N - 1).append('\n');
        }
        System.out.print(sb);
    }

    static void init(int N, int M) throws IOException {
        while (M-- > 0) {
            readInt();
            readInt();
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