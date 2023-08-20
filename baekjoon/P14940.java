import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class P14940 {

    static final String SPACE = " ";
    static int[][] graph;
    static boolean[][] visited;
    static int N, M;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();

        graph = new int[N][M];
        visited = new boolean[N][M];

        int startX = 0, startY = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = readInt();
                if (graph[i][j] == 2) {
                    startX = j;
                    startY = i;
                } else if (graph[i][j] == 1) {
                    graph[i][j] = -1;
                }
            }
        }

        bfs(startX, startY);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(graph[i][j]).append(SPACE);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static void bfs(int startX, int startY) {
        final int[] dx = { 0, 1, 0, -1 };
        final int[] dy = { -1, 0, 1, 0 };
        Queue<Point> q = new LinkedList<>();

        graph[startY][startX] = 0;
        visited[startY][startX] = true;
        q.offer(new Point(startX, startY));

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }
                if (!visited[ny][nx] && graph[ny][nx] != 0) {
                    graph[ny][nx] = graph[now.y][now.x] + 1;
                    visited[ny][nx] = true;
                    q.offer(new Point(nx, ny));
                }
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