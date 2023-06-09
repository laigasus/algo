import java.io.IOException;
import java.util.stream.IntStream;

public class P1024 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = readInt(), L = readInt();
        long[] dp = new long[(N / 2 + 1) + 1];
        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + (i - 1);
        }

        do {
            for (int k = 0; k < dp.length - L; k++) {
                if (dp[k + L] - dp[k] == N) {
                    for (int a : IntStream.range(k, k + L).toArray()) {
                        sb.append(a).append(' ');
                    }
                    System.out.println(sb);
                    return;
                }
            }
        } while (L++ <= 100);

        System.out.println(-1);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }
}