import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[101][10];

        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j >= 1) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j <= 8) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
                dp[i][j] %= 1_000_000_000;
            }
        }

        int rs = 0;
        for (int num : dp[N]) {
            rs = (rs + num) % 1_000_000_000;
        }

        System.out.println(rs);
    }
}