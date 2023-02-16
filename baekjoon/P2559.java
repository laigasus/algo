import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] dp = new int[N];

        String[] str = br.readLine().split(" ");
        dp[0] = arr[0] = Integer.valueOf(str[0]);
        int max;

        if (N == K) {
            max = Arrays.stream(str).mapToInt(Integer::parseInt).sum();
        } else {
            for (int i = 1; i < K; i++) {
                arr[i] = Integer.valueOf(str[i]);
                dp[i] += dp[i - 1] + arr[i];
            }
            max = dp[K - 1];

            for (int i = K; i < N; i++) {
                arr[i] = Integer.valueOf(str[i]);
                dp[i] += dp[i - 1] + arr[i];
                max = Math.max(max, dp[i] - dp[i - K]);
            }
        }

        br.close();
        System.out.println(max);
    }
}
