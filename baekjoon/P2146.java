import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class P2146 {
    static int[][] graph;
    static boolean[][] visited;
    static int N, lands = 2, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = readInt();

        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = readInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    graph[i][j] = lands;
                    visited[i][j] = true;
                    dfs(i, j);
                    lands++;
                }

                if (graph[i][j] != 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(min);
    }

    static class Point {
        int y, x, len;

        public Point(int y, int x, int len) {
            this.y = y;
            this.x = x;
            this.len = len;
        }
    }

    static final int[] dx = { -1, 0, 1, 0 };
    static final int[] dy = { 0, -1, 0, 1 };

    private static void bfs(int y, int x) {
        Deque<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        visited[y][x] = true;

        q.offer(new Point(y, x, 0));

        while (!q.isEmpty()) {
            Point point = q.poll();
            if (point.len >= min) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if (visited[ny][nx]) {
                    continue;
                }

                if (graph[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    q.offer(new Point(ny, nx, point.len + 1));
                } else if (graph[ny][nx] != graph[y][x]) {
                    min = Math.min(min, point.len);
                    q.clear();
                }
            }
        }
    }

    private static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }

            if (visited[ny][nx]) {
                continue;
            }

            if (graph[ny][nx] == 1) {
                visited[y][x] = true;
                graph[ny][nx] = lands;
                dfs(ny, nx);
            }
        }
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