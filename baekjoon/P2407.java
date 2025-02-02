import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P2407 {

    private static final int SIZE = 100;
    private static BigInteger[][] dp = new BigInteger[SIZE + 1][SIZE + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = combi(i, j);
            }
        }

        System.out.println(dp[n][m]);
    }

    private static BigInteger combi(int n, int r) {
        if (dp[n][r] != null) {
            return dp[n][r];
        } else if (n == r || r==0) {
            return dp[n][r] = BigInteger.ONE;
        } else if (r == 1) {
            return dp[n][r] = BigInteger.valueOf(n);
        } else {
            return combi(n - 1, r - 1).add(combi(n - 1, r));
        }
    }
}
