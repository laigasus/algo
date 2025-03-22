import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P22869 {

    private static int N, K;
    private static int[] arr;
    private static boolean[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dp = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = true;
        move(0);

        System.out.println(dp[N - 1] ? "YES" : "NO");
    }

    private static void move(int i) {
        if (i == N) {
            return;
        }

        dp[i] = true;
        for (int j = N - 1; j > i; j--) {
            if (dp[j]) {
                continue;
            }

            int cost = (j - i) * (1 + Math.abs(arr[i] - arr[j]));
            if (cost <= K) {
                dp[j] = true;
                move(j);
            }
        }
    }
}
