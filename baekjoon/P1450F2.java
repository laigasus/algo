import java.io.IOException;

public class P1450F2 {
    static int N, C;
    static int[] stuff;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        N = readInt();
        C = readInt();

        stuff = new int[N];
        dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            stuff[i] = readInt();
        }

        dp[1] = stuff[0];
        for (int i = 1; i < N; i++) {
            dp[i + 1] = dp[i] + stuff[i]; 
        }

        int cnt = 1;
        int start = 0, end = start + 1;

        while (end <= N) {
            if (end == start) {
                end++;
            } else if (dp[end] - dp[start] < C) {
                cnt++;
                end++;
            } else if (dp[end] - dp[start] == C) {
                cnt++;
                start++;
            } else {
                start++;
            }
        }

        System.out.println(cnt);
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