import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11717_2 {

    private static final int DIV = 10_007;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        dp[1] = 1;

        if (n > 1) {
            dp[2] = 3;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % DIV;
        }

        System.out.println(dp[n]);
    }
}
