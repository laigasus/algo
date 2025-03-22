import java.io.IOException;

public class P15486 {

    private static int N;
    private static int[] T, P;
    private static int[] dp;

    public static void main(String[] args) throws IOException {

        N = readInt();
        T = new int[N + 1];
        P = new int[N + 1];

        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            T[i] = readInt();
            P[i] = readInt();
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);

            int next = i + T[i];

            if (next <= N + 1) {
                dp[next] = Math.max(dp[next], dp[i] + P[i]);
            }

        }

        System.out.println(Math.max(dp[N], dp[N + 1]));
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
