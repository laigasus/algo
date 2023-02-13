import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9461 {
    static long dp[] = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sb.append(padovan(Integer.parseInt(br.readLine()))).append("\n");
        }
        br.close();

        System.out.print(sb);
    }

    static long padovan(int n) {
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
