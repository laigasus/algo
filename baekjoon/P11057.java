import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.LongStream;

class P11057 {
    static final int DIVIDER = 10_007;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[][] dp = new long[n + 1][10];

        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= 9; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % DIVIDER;
            }
        }

        long sum = LongStream.of(dp[n]).sum() % DIVIDER;

        System.out.println(sum);
    }

}