import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P14916 {

    private static int[] dp;
    private static final int[] coins = { 5, 2 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int coin : coins) {
            for (int total = 0; total + coin <= n; total++) {
                if (dp[total] != Integer.MAX_VALUE) {
                    dp[total + coin] = Math.min(dp[total + coin], dp[total] + 1);
                }
            }
        }

        System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
    }
}
