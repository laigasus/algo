import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class P2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[K + 1][N + 1];

        if (K == 1) {
            System.out.println(1);
            return;
        }
        Arrays.fill(dp[1], 1);
        dp[2] = IntStream.rangeClosed(1, N + 1).toArray();

        if (K > 2) {
            for (int i = 3; i <= K; i++) {
                dp[i][0] = 1;
                for (int j = 1; j <= N; j++) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
                }
            }
        }

        System.out.println(dp[K][N]);
    }
}