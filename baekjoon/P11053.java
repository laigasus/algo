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