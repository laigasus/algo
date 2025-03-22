import java.io.IOException;
import java.util.Arrays;

public class P1106F {

    private static class City {
        int v;
        int w;

        public City(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private static int[] dp;
    private static City[] cities;
    private static int C, N;
    private static final int MAX_V_PER_CITY = 100;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        C = readInt();
        N = readInt();

        cities = new City[N];
        dp = new int[C + MAX_V_PER_CITY];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            int cost = readInt();
            int customers = readInt();

            cities[i] = new City(customers, cost);
        }

        for (City city : cities) {
            for (int v = city.v; v < C + MAX_V_PER_CITY; v++) {
                if (dp[v - city.v] != INF) {
                    dp[v] = Math.min(dp[v], dp[v - city.v] + city.w);
                }
            }
        }

        int result = dp[C];

        for (int i = C; i < MAX_V_PER_CITY; i++) {
            result = Math.min(result, dp[i]);
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
