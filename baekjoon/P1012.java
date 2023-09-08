import java.io.IOException;

public class P1012 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };
    static int cnt = 0;
    static int M, N, K;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int T = readInt();

        while (T-- > 0) {
            sb.append(getMinWorm()).append('\n');
        }

        System.out.print(sb);
    }

    static int getMinWorm() throws IOException {
        int cnt = 0;
        int x = 0, y = 0;

        M = readInt();
        N = readInt();
        K = readInt();

        graph = new int[N][M];
        visited = new boolean[N][M];

        while (K-- > 0) {
            x = readInt();
            y = readInt();

            graph[y][x] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    dfs(i, j);
                    cnt++;
                } else {
                    visited[i][j] = true;
                }
            }
        }

        return cnt;
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                continue;
            }

            if (visited[ny][nx]) {
                continue;
            }

            if (graph[ny][nx] == 1) {
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
