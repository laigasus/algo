import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[1000];
        int[] dp = new int[1001];

        int idx = 0, num = 1;
        while (idx < arr.length) {
            for (int i = 1; i <= num && idx < arr.length; i++) {
                arr[idx] = num;
                dp[idx + 1] = dp[idx] + arr[idx];
                idx++;
            }
            num++;
        }

        System.out.println(dp[B] - dp[A - 1]);
    }
}