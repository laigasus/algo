import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class P10844_2 {
    static final int DIVIDER = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
            for (int j = 1; j < dp[i].length - 1; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % DIVIDER;
            }
        }

        int sum = 0;
        for (int j = 1; j <= 9; j++) {
            sum = (sum + dp[N][j]) % DIVIDER;
        }

        System.out.println(sum);
    }

}