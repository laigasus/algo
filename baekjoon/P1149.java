import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P1149 {
    final static int R = 0, G = 1, B = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            dp[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();

        for (int i = 1; i < N; i++) {
            dp[i][R] += Math.min(dp[i - 1][G], dp[i - 1][B]);
            dp[i][G] += Math.min(dp[i - 1][B], dp[i - 1][R]);
            dp[i][B] += Math.min(dp[i - 1][R], dp[i - 1][G]);
        }

        int rs = Collections.min(List.of(dp[N - 1][R], dp[N - 1][G], dp[N - 1][B]));
        System.out.println(rs);
    }
}
