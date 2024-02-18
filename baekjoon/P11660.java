import java.io.IOException;

public class P11660 {

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt();

        int[][] arr = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = readInt();
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            Point start, end;

            start = new Point(readInt() - 1, readInt() - 1);
            end = new Point(readInt(), readInt());

            sb.append(calc(dp, start, end)).append('\n');
        }

        System.out.print(sb);
    }

    private static int calc(int[][] dp, Point start, Point end) {
        return dp[end.x][end.y] - dp[end.x][start.y] - dp[start.x][end.y] + dp[start.x][start.y];
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