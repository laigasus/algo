import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11051 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][K + 1];

        System.out.print(bin(N, K));
    }

    static int bin(int N, int K) {
        if (dp[N][K] > 0) {
            return dp[N][K];
        }

        if (N == K || K == 0) {
            return dp[N][K] = 1;
        }

        return dp[N][K] = (bin(N - 1, K - 1) + bin(N - 1, K)) % 10007;
    }
}
