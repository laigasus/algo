import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1904 {
    static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(tiles(Integer.parseInt(br.readLine())));
    }

    static int tiles(int n) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
        }
        return dp[n];
    }
}
