import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660 {
    static int dp[][], arr[][];
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = nextInt(st), M = nextInt(st);

        init(N, M);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = nextInt(st), y1 = nextInt(st), x2 = nextInt(st), y2 = nextInt(st);
            sb.append(sumRange(x1, y1, x2, y2)).append("\n");
        }

        System.out.print(sb);
    }

    static int nextInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static void init(int N, int M) throws IOException {
        dp = new int[N + 1][N + 1];
        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = nextInt(st);
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + arr[i][j];
            }
        }
    }

    static int sumRange(int x1, int y1, int x2, int y2) {
        return dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
    }
}
