import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[M];

        st = new StringTokenizer(br.readLine());
        br.close();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken()) % M;
            dp[sum % M]++;
        }

        long rs = dp[0];
        for (int i = 0; i < M; i++) {
            long cnt = dp[i];
            rs += (cnt * (cnt - 1)) >> 1;
        }

        System.out.println(rs);
    }
}
