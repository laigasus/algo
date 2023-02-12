import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P24416 {
    static int[] dp;
    static int cnt1 = 0, cnt2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[41];

        fib(n);
        fibonacci(n);

        System.out.println(cnt1 + " " + cnt2);
        br.close();
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            cnt1++;
            return 1;
        } else {
            return (fib(n - 1) + fib(n - 2));
        }

    }

    static int fibonacci(int n) {
        dp[1] = 1;
        dp[2] = 1;
        if (n == 1 || n == 2) {
            cnt2++;
            return 1;
        }
        for (int i = 3; i <= n; i++) {
            cnt2++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
