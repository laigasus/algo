import java.io.IOException;

public class P11053 {
    public static void main(String[] args) throws IOException {
        int A = readInt();
        int[] arr = new int[A];
        int[] dp = new int[A];

        for (int i = 0; i < A; i++) {
            arr[i] = readInt();
        }

        int max = 1;
        for (int i = 0; i < A; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
            }

            max = Integer.max(max, dp[i]);
        }

        System.out.println(max);
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