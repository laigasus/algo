import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        dp[0] = arr[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] += dp[i - 1] + arr[i];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            if (start == end) {
                sb.append(arr[start]).append("\n");
            } else if (start == 0) {
                sb.append(dp[end]).append("\n");
            } else {
                sb.append(dp[end] - dp[start - 1]).append("\n");
            }
        }
        br.close();
        System.out.print(sb);
    }
}
