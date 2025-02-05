import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class P17836 {

    private static int[][] graph;
    private static int N, M, T;

    private static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();
        T = readInt();

        Point graam = null;
        Point prince = new Point(N - 1, M - 1);
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int num = readInt();
                if (num == 2) {
                    graam = new Point(i, j);
                } else if (num == 1) {
                    graph[i][j] = -1;
                }
            }
        }

        int result = bfs(graam, prince);

        System.out.println(result <= T ? result : "Fail");
    }

    private static int bfs(Point graam, Point princess) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        Point start = new Point(0, 0);

        final int[] dy = { 0, -1, 0, 1 };
        final int[] dx = { -1, 0, 1, 0 };

        int result = Integer.MAX_VALUE;

        q.offer(start);
        visited[start.y][start.x] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (existsPrincess(princess, now)) {
                result = Math.min(result, graph[N - 1][M - 1]);
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (!isBoundry(ny, nx) || visited[ny][nx]) {
                    continue;
                }

                if (graph[ny][nx] != -1) {
                    visited[ny][nx] = true;
                    graph[ny][nx] = graph[now.y][now.x] + 1;
                    q.offer(new Point(ny, nx));
                }
            }
        }

        if (graph[graam.y][graam.x] > 0) {
            result = Math.min(result, graph[graam.y][graam.x] + calcGraalPathCost(graam));
        }

        return result;
    }

    private static boolean existsPrincess(Point princess, Point now) {
        return now.y == princess.y && now.x == princess.x;
    }

    private static int calcGraalPathCost(Point graam) {
        return Math.abs((N - 1) - graam.y) + Math.abs((M - 1) - graam.x);
    }

    private static boolean isBoundry(int y, int x) {
        return x >= 0 && y >= 0 && x < M && y < N;
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
