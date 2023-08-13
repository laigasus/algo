import java.io.IOException;

public class P9095 {
    final static int[] MAGIC_NUMS = { 1, 2, 3 };
    static int cases, N;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();

        while (T-- > 0) {
            cases = 0;
            N = readInt();
            calc(0);
            sb.append(cases).append('\n');
        }

        System.out.print(sb);
    }

    static void calc(int sum) {
        if (sum > N) {
            return;
        }

        if (sum == N) {
            cases++;
            return;
        }

        for (int num : MAGIC_NUMS) {
            calc(sum + num);
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