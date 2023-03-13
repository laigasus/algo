import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int totalWeight = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            totalWeight += num;
            arr[i] = num;
        }
        boolean[] dp = new boolean[40001];

        int T = Integer.parseInt(br.readLine());

        dp[0] = true;

        for (int i = 0; i < N; i++) {
            for (int j = totalWeight; j >= 0; j--) {
                if (dp[j]) {
                    dp[j + arr[i]] = true;
                }
            }

            for (int j = 0; j <= totalWeight; j++) {
                if (dp[j]) {
                    dp[Math.abs(j - arr[i])] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            sb.append(dp[Integer.parseInt(st.nextToken())] ? "Y" : "N").append(" ");
        }
        System.out.println(sb);
    }
}