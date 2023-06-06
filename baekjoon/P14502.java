import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class P14502 {
    static int[][] graph;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int N, M;
    static int max = 0;
    static Queue<Node> queue;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = readInt();
            }
        }

        dfs(0);
        System.out.println(max);
    }

    static void dfs(int walls) {
        if (walls == 3) {
            max = Math.max(max, bfs());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    dfs(walls + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    static int bfs() {
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 2) {
                    queue.offer(new Node(i, j));
                }
            }
        }

        int[][] graphCopy = new int[N][M];

        for (int i = 0; i < N; i++) {
            graphCopy[i] = graph[i].clone();
        }

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (graphCopy[nx][ny] == 0) {
                    graphCopy[nx][ny] = 2;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
        return cntSafeZone(graphCopy);
    }

    private static int cntSafeZone(int[][] graphCopy) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graphCopy[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }
}