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