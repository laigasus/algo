import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P2294 {

    private static List<Integer> coins;
    private static int[] dp;
    private static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new ArrayList<>();
        dp = new int[k + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            coins.add(num);
        }

        for (int coin : coins) {
            for (int i = 0; i + coin <= k; i++) {
                if (dp[i] != Integer.MAX_VALUE) {
                    dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
                }
            }
        }

        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
    }
}
