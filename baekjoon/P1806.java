import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        dp[1] = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, min = Integer.MAX_VALUE;
        while (right <= N) {
            if (dp[right] - dp[left] < S) {
                right++;
            } else {
                min = Math.min(min, right - left);
                left++;
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
