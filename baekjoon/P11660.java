import java.io.IOException;

public class P11660 {
    static int[][] dp, arr;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();

        init();
        calc();

        System.out.print(sb);
    }

    static void init() throws IOException {
        dp = new int[N + 1][N + 1];
        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = readInt();
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + arr[i][j];
            }
        }
    }

    static void calc() throws IOException {
        for (int i = 0; i < M; i++) {
            int x1 = readInt(), y1 = readInt();
            int x2 = readInt(), y2 = readInt();
            sb.append(sumRange(x1, y1, x2, y2)).append('\n');
        }
    }

    private static int sumRange(int x1, int y1, int x2, int y2) {
        return dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
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