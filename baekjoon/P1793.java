import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P1793 {
    static final int MAX = 250;
    static BigInteger[] dp = new BigInteger[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        init();

        String s;

        while ((s = br.readLine()) != null) {
            int num = Integer.parseInt(s);

            sb.append(dp[num]).append('\n');
        }

        System.out.print(sb);
    }

    private static void init() {
        dp[0] = BigInteger.valueOf(1);
        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(3);

        for (int i = 3; i <= MAX; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
        }
    }

}
