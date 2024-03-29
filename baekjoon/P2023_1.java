import java.io.IOException;
import java.math.BigInteger;

public class P2023_1 {

    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        N = readInt();

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        System.out.print(sb);
    }

    private static void dfs(int num, int depth) {
        if (depth == N) {
            if (isPrimary(num)) {
                sb.append(num).append('\n');
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (isPrimary(num * 10 + i)) {
                dfs(num * 10 + i, depth + 1);
            }
        }
    }

    private static boolean isPrimary(int num) {
        return BigInteger.valueOf(num).isProbablePrime(10);
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
