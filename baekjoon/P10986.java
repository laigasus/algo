import java.io.IOException;

public class P10986 {
    public static void main(String[] args) throws IOException {
        int N = readInt();
        int M = readInt();

        int[] prefixSum = new int[N + 1];
        int[] dp = new int[M];

        for (int i = 1; i <= N; i++) {
            prefixSum[i] = readInt();
            prefixSum[i] = (prefixSum[i] + prefixSum[i - 1]) % M;

            dp[prefixSum[i]]++;
        }

        long result = dp[0];
        for (int i = 0; i < M; i++) {
            if (dp[i] >= 2) {
                result += (long) dp[i] * (dp[i] - 1) / 2;
            }
        }

        System.out.println(result);
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
