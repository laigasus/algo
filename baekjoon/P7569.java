import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class P7569 {
    static int[][][] graph;
    static boolean[][][] visited;
    static final int NONE = -1;
    static int M, N, H;
    static Queue<Location> q;

    public static void main(String[] args) throws IOException {
        init();
        bfs();

        System.out.println(getResult());
    }

    static class Location {
        int h, n, m, time;

        public Location(int h, int n, int m, int time) {
            this.h = h;
            this.n = n;
            this.m = m;
            this.time = time;
        }
    }

    static void init() throws IOException {
        M = readInt();
        N = readInt();
        H = readInt();
        graph = new int[H][N][M];
        visited = new boolean[H][N][M];
        q = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if ((graph[h][n][m] = readInt()) == 1) {
                        q.offer(new Location(h, n, m, 0));
                    }
                }
            }
        }
    }

    static int getResult() {
        int rs = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (graph[h][n][m] == 0) {
                        return -1;
                    }
                    rs = Math.max(rs, graph[h][n][m]);
                }
            }
        }
        return rs == 1 ? 0 : rs;
    }

    static final int[] dh = { 0, 0, 0, 0, -1, 1 };
    static final int[] dn = { -1, 0, 1, 0, 0, 0 };
    static final int[] dm = { 0, 1, 0, -1, 0, 0 };

    static void bfs() {
        while (!q.isEmpty()) {
            Location now = q.poll();
            int h = now.h, n = now.n, m = now.m;

            // 6방위 탐색
            for (int idx = 0; idx < dh.length; idx++) {
                int th = h + dh[idx];
                int tn = n + dn[idx];
                int tm = m + dm[idx];

                // 보관함 범위 벗어나면 pass
                if (th < 0 || th >= H || tn < 0 || tn >= N || tm < 0 || tm >= M) {
                    continue;
                }

                // 비어있으면(벽으로 간주) pass
                if (graph[th][tn][tm] == -1) {
                    continue;
                }

                // 이미 익었으면 pass
                if (graph[th][tn][tm] > 0) {
                    continue;
                }

                graph[th][tn][tm] = now.time + 1;
                q.offer(new Location(th, tn, tm, now.time + 1));
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