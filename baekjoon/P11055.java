import java.io.IOException;
import java.util.stream.IntStream;

public class P11055 {
    public static void main(String[] args) throws IOException {
        int N = readInt();

        int[] dp = new int[N + 1];
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        for (int i = 0; i < N; i++) {
            dp[i] = A[i];
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
        }

        System.out.println(IntStream.of(dp).max().getAsInt());
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
