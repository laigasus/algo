import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(calc(board));
    }

    private static class Point {
        int x, y;

        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }

        static final Point[] dir = {
                new Point(0, -1),
                new Point(-1, 0),
                new Point(0, 1),
                new Point(1, 0),
        };
    }

    private static int calc(int[][] board) {
        final int N = board.length;
        final int M = board[0].length;

        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(0, 0));

        while (!queue.isEmpty()) {
            var now = queue.poll();

            for (var d : Point.dir) {
                int nx = now.x + d.x;
                int ny = now.y + d.y;

                if (!isBoundary(N, M, nx, ny)) {
                    continue;
                }

                if (board[ny][nx] == 0) {
                    continue;
                }

                if (board[ny][nx] == 1) {
                    board[ny][nx] = board[now.y][now.x] + 1;
                    var next = new Point(ny, nx);
                    queue.offer(next);
                }
            }
        }

        return board[N - 1][M - 1];
    }

    private static boolean isBoundary(final int N, final int M, int nx, int ny) {
        return (nx < 0 || ny < 0 || nx >= M || ny >= N) ? false : true;
    }

}