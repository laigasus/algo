import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine(), t = br.readLine();
        int max = 0, sLen = s.length(), tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}
