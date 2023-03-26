import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class P1644 {
    final static int range = 4000000;
    static boolean[] prime = new boolean[range + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        initPrime();
        int[] arr = IntStream.rangeClosed(2, N).filter(e -> isPrimary(e)).toArray();
        int[] dp = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            dp[i + 1] = dp[i] + arr[i];
        }

        int left = 0, right = 1, cnt = 0;
        long sum = 0;
        while (left <= right && right < dp.length) {
            sum = dp[right] - dp[left];
            if (sum > N) {
                left++;
            } else if (sum < N) {
                right++;
            } else {
                cnt++;
                left++;
            }
        }

        System.out.println(cnt);
    }

    static void initPrime() {
        prime[0] = prime[1] = true;
        int rg = (int) Math.sqrt(range);
        for (int i = 2; i <= rg; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= range; j += i)
                    prime[j] = true;
            }
        }
    }

    static boolean isPrimary(int n) {
        return !prime[n];
    }
}
