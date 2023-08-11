import java.io.IOException;

public class P9465 {

    static final int SIZE = 2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();

        while (T-- > 0) {
            int n = readInt();
            dp = new int[SIZE][n + 1];

            for (int i = 0; i < SIZE; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = readInt();
                }
            }

            dp[0][1] += dp[0][0];
            dp[1][1] += dp[1][0];

            for (int i = 2; i <= n; i++) {
                dp[0][i] += Math.max(dp[1][i - 1], dp[1][i - 2]);
                dp[1][i] += Math.max(dp[0][i - 1], dp[0][i - 2]);
            }

            sb.append(Math.max(dp[0][n], dp[1][n])).append('\n');
        }

        System.out.print(sb);
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