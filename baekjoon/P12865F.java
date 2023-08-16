import java.io.IOException;

public class P12865F {

    static int N, K, V;
    static int[][] dp;

    static class Stuff {
        int W, V;

        public Stuff(int W, int V) {
            this.W = W;
            this.V = V;
        }
    }

    public static void main(String[] args) throws IOException {
        N = readInt();
        K = readInt();

        Stuff[] stuffs = init();

        calc(stuffs);

        System.out.println(dp[N][K]);
    }

    private static void calc(Stuff[] stuffs) {
        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= K; w++) {
                if (stuffs[n].W > w) {
                    dp[n][w] = dp[n - 1][w];
                } else {
                    dp[n][w] = Math.max(dp[n - 1][w], dp[n - 1][w - stuffs[n].W] + stuffs[n].V);
                }
            }
        }
    }

    private static Stuff[] init() throws IOException {
        dp = new int[N + 1][K + 1];
        Stuff[] stuffs = new Stuff[N + 1];
        stuffs[0] = new Stuff(0, 0);

        for (int i = 1; i <= N; i++) {
            stuffs[i] = new Stuff(readInt(), readInt());
        }
        return stuffs;
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