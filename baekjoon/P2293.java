import java.io.IOException;

public class P2293 {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int K = readInt();
        int[] coins = new int[N];
        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            coins[i] = readInt();
        }

        dp[0] = 1;

        for (int coin : coins) {
            for (int price = 1; price <= K; price++) {
                if (price >= coin) {
                    dp[price] += dp[price - coin];
                }
            }
        }

        System.out.println(dp[K]);
    }

    private static int readInt() throws IOException {
        int rs = 0;
        boolean isNegative = false;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        if (c == '-') {
            isNegative = true;
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return isNegative ? -rs : rs;
    }
}
