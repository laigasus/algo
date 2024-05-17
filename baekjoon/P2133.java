import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class P2133 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        dp[0] = 1;
        if (N >= 2) {
            dp[2] = 3;
        }

        for (int i = 4; i <= N; i += 2) {
            int j = i - 2;
            dp[i] = dp[j] * 3;

            while ((j -= 2) >= 0) {
                dp[i] += dp[j] * 2;
            }
        }

        System.out.println(dp[N]);
    }
}