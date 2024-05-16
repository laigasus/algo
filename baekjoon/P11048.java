import java.io.FileInputStream;
import java.io.IOException;

class P11048 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        int N = readInt();
        int M = readInt();

        int[][] dp = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i + 1][j + 1] = readInt();
            }
        }

        for (int i = 1; i <= N; i++) {
            dp[i][1] += dp[i - 1][1];
        }

        for (int j = 1; j <= M; j++) {
            dp[1][j] += dp[1][j - 1];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= M; j++) {
                dp[i][j] += Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[N][M]);

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