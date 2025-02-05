import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class P14940_2 {

    private static int n, m;
    private static int[][] graph;
    private static boolean[][] visited;

    private static class Pos {
        int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        n = readInt();
        m = readInt();

        graph = new int[n][m];
        visited = new boolean[n][m];

        int startX = 0, startY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = readInt();

                if (graph[i][j] == 2) {
                    startX = j;
                    startY = i;
                } else if (graph[i][j] == 1) {
                    graph[i][j] = -1;
                }
            }
        }

        BFS(new Pos(startY, startX));
        printGraph();
    }

    public static void BFS(Pos start) {
        final int[] dx = { -1, 0, 1, 0 };
        final int[] dy = { 0, -1, 0, 1 };

        Queue<Pos> q = new LinkedList<>();

        q.offer(start);
        visited[start.y][start.x] = true;
        graph[start.y][start.x] = 0;

        while (!q.isEmpty()) {
            Pos now = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (!isBoundry(nx, ny)) {
                    continue;
                }

                if (!visited[ny][nx] && graph[ny][nx] != 0) {
                    q.offer(new Pos(ny, nx));
                    visited[ny][nx] = true;
                    graph[ny][nx] = graph[now.y][now.x] + 1;
                }

            }
        }

    }

    public static void printGraph() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(graph[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static boolean isBoundry(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < n && nx < m;
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
