import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1010_2 {
    private static final int MAX = 30;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(dp[M][N]).append('\n');
        }

        System.out.print(sb);

    }

    private static void init() {
        dp = new int[MAX + 1][MAX + 1];
        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j <= i; j++) {
                combi(i, j);
            }
        }
    }

    private static int combi(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        } else if (n == r || r == 0) {
            return dp[n][r] = 1;
        } else {
            return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }
}
