import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1799 {
    static int N;
    static int[] max = new int[2];
    static int[][] board;
    static int len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        len = N * N;
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calc(true, 0, 0);
        calc(false, 1, 0);
        System.out.println(max[0] + max[1]);
    }

    static void calc(boolean black, int idx, int cnt) {

        for (int i = idx; i < len; i++) {
            int y = i / N;
            int x = i % N;

            if (board[y][x] == 0 || ((x + y) % 2 == 1 != black) || !isValid(x, y))
                continue;

            board[y][x] = -1;
            calc(black, i + 1, cnt + 1);
            board[y][x] = 1;
        }

        max[black ? 0 : 1] = Math.max(max[black ? 0 : 1], cnt);
    }

    static int[] dx = { -1, 1 };
    static int[] dy = { -1, -1 };

    static boolean isValid(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int nx = x;
            int ny = y;
            while (true) {
                if (0 > nx || nx >= N || 0 > ny || ny >= N) {
                    break;
                }

                if (board[ny][nx] == -1) {
                    return false;
                }

                nx += dx[i];
                ny += dy[i];
            }
        }
        return true;
    }
}