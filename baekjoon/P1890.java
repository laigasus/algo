import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1890 {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        long[][] dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        loop: for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                int move = arr[y][x];
                if (move == 0) {
                    break loop;
                }
                if (isValid(x + move)) {
                    dp[y][x + move] += dp[y][x];
                }
                if (isValid(y + move)) {
                    dp[y + move][x] += dp[y][x];
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }

    private static boolean isValid(int x) {
        return x < N;
    }
}
