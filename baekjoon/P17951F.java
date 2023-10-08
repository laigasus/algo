import java.io.IOException;
import java.util.Arrays;

public class P17951F {
    static int[] dp;
    static int[] divider;
    static int N, K;

    public static void main(String[] args) throws IOException {
        N = readInt();
        K = readInt();

        int[] tests = new int[N];
        dp = new int[N + 1];
        divider = new int[K + 1];

        for (int i = 0; i < N; i++) {
            tests[i] = readInt();
            dp[i + 1] = dp[i] + tests[i];
        }
        divider[0] = 0;
        divider[K] = N - 1;

        System.out.println(Arrays.toString(tests));
        System.out.println(Arrays.toString(dp));

        dfs(1, 1);

        System.out.println(min);
    }

    static int min = Integer.MAX_VALUE;

    private static void dfs(int idx, int depth) {
        if (depth == K) {
            for (int i = 0; i < K - 1; i++) {
                min = Math.min(min, dp[divider[i + 1]] - dp[divider[i]]);
            }
            return;
        }

        for (int i = idx; i < N; i++) {
            divider[depth] = i;
            dfs(idx + 1, depth + 1);
            divider[depth] = 0;
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
