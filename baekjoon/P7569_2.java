import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class P7569_2 {
    static StringBuilder sb = new StringBuilder();
    static int[][][] board;
    static Queue<Point> q = new LinkedList<>();
    static int M, N, H;
    static int len = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        init(sc);

        bfs();

        System.out.println(getMin());

    }

    private static void init(Scanner sc) {
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        board = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if ((board[i][j][k] = sc.nextInt()) == 1) {
                        q.offer(new Point(i, j, k, 1));
                    }
                }
            }
        }
    }

    private static int getMin() {
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (board[i][j][k] == 0) {
                        return -1;
                    }

                    min = Math.max(min, board[i][j][k]);
                }
            }
        }

        return min - 1;
    }

    private static class Point {
        int z, y, x, days;

        public Point(int z, int y, int x, int days) {
            this.z = z;
            this.y = y;
            this.x = x;
            this.days = days;
        }
    }

    static final int[] dx = { 0, 0, -1, 1, 0, 0 };
    static final int[] dy = { 0, 0, 0, 0, -1, 1 };
    static final int[] dz = { -1, 1, 0, 0, 0, 0 };
    // 1 익음, 0 익지 않음, -1 없음

    private static void bfs() {
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int nz = now.z + dz[i];
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (!isBoundry(nz, ny, nx)) {
                    continue;
                }

                if (board[nz][ny][nx] == -1) {
                    continue;
                }

                Point next = new Point(nz, ny, nx, now.days + 1);

                if (board[nz][ny][nx] > 0) {
                    continue;
                }

                board[nz][ny][nx] = next.days;
                q.offer(next);
            }
        }

    }

    private static boolean isBoundry(int nz, int ny, int nx) {
        return nz >= 0 && ny >= 0 && nx >= 0 && nz < H && ny < N && nx < M;
    }

}