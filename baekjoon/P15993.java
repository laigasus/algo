import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.LongStream;

public class P15993 {
    private static final int MAX_SIZE = 100_000;

    private static Numbers[] dp = new Numbers[MAX_SIZE + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        dp[1] = new Numbers(1, 0);
        dp[2] = new Numbers(1, 1);
        dp[3] = new Numbers(2, 2);

        for (int i = 4; i <= MAX_SIZE; i++) {
            dp[i] = new Numbers()
                    .odds(dp[i - 1].even, dp[i - 2].even, dp[i - 3].even)
                    .evens(dp[i - 1].odd, dp[i - 2].odd, dp[i - 3].odd);
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Numbers result = dp[n];

            sb.append(result.odd);
            sb.append(' ');
            sb.append(result.even);
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static class Numbers {
        private final int DIV = 1_000_000_009;
        long odd, even;

        public Numbers(long odd, long even) {
            this.odd = odd;
            this.even = even;
        }

        public Numbers() {
            this.odd = 0;
            this.even = 0;
        }

        public Numbers odds(long... nums) {
            this.odd = LongStream.of(nums).sum() % DIV;
            return this;
        }

        public Numbers evens(long... nums) {
            this.even = LongStream.of(nums).sum() % DIV;
            return this;
        }
    }
}
