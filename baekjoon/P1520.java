import java.io.IOException;

public class P1520 {
    static final int NOT_CHECKED = -1;
    static int M, N;
    static int[][] board, dp;

    public static void main(String[] args) throws IOException {
        M = readInt();
        N = readInt();

        board = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = readInt();
                dp[i][j] = NOT_CHECKED;
            }
        }

        System.out.println(dfs(0, 0));
    }

    static final int[] dy = { 0, -1, 0, 1 };
    static final int[] dx = { -1, 0, 1, 0 };

    private static int dfs(int y, int x) {
        if (y == M - 1 && x == N - 1) {
            return 1;
        }

        if (dp[y][x] != NOT_CHECKED) {
            return dp[y][x];
        }

        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            if (board[ny][nx] >= board[y][x]) {
                continue;
            }

            dp[y][x] += dfs(ny, nx);
        }

        return dp[y][x];
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
