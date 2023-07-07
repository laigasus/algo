import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {
    static Queue<Node> queue = new LinkedList<>();
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int[][] graph;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if ((graph[i][j] = Integer.parseInt(st.nextToken())) == 1) {
                    queue.offer(new Node(j, i));
                }
            }
        }

        bfs();

        int totalDays = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                if (totalDays < graph[i][j]) {
                    totalDays = graph[i][j];
                }
            }
        }
        System.out.println(totalDays - 1);
    }

    private static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }

                if (graph[ny][nx] == -1) {
                    continue;
                }

                if (graph[ny][nx] == 0) {
                    graph[ny][nx] = graph[y][x] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
    }
}