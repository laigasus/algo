import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(getMaxSum(Integer.parseInt(br.readLine()), br.readLine()));
    }

    static int getMaxSum(int n, String str) {
        int dp[] = new int[n];
        StringTokenizer st = new StringTokenizer(str);
        dp[0] = Integer.parseInt(st.nextToken());
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i - 1] + num, num);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
