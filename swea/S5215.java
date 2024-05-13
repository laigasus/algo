import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class S5215 {
    static StringBuilder sb = new StringBuilder();
    static int[][] dp;
    static int[] v, w;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int L = sc.nextInt();
            v = new int[N + 1];
            w = new int[N + 1];
            dp = new int[N + 1][L + 1];

            for (int i = 1; i <= N; i++) {
                v[i] = sc.nextInt();
                w[i] = sc.nextInt();
            }

            for (int n = 1; n <= N; n++) {
                for (int weight = 1; weight <= L; weight++) {
                    if (w[n] <= weight) {
                        dp[n][weight] = Math.max(dp[n - 1][weight], dp[n - 1][weight - w[n]] + v[n]);
                    } else {
                        dp[n][weight] = dp[n - 1][weight];
                    }
                }
            }

            int result = dp[N][L];
            sb.append(String.format("#%d %d\n", test_case, result));
        }

        System.out.println(sb);
    }

}