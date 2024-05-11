
import java.util.Scanner;

class S2001 {
    static int[][] dp;
    static int N, M;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();

            dp = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dp[i][j] = sc.nextInt();
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dp[i][j] += dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
                }
            }

            int result = calc();
            sb.append("#" + test_case + " " + result + "\n");
        }
        System.out.println(sb);
    }

    private static int calc() {
        int max = 0;
        for (int i = 0; i <= N - M; i++) {
            for (int j = 0; j <= N - M; j++) {
                int value = dp[i + M][j + M] - dp[i + M][j] - dp[i][j + M] + dp[i][j];
                max = Math.max(max, value);
            }
        }

        return max;
    }
}