import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9663F {
    static int N;
    static int cnt = 0;
    static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
    static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];

        calc(0, graph);
        System.out.println(cnt);
    }

    static void calc(int y, int[][] graph) {
        if (y >= N) {
            cnt++;
            // printGraph(y, graph);
            return;
        }

        for (int x = 0; x < N; x++) {
            if (graph[y][x] == -1) {
                continue;
            }
            if (graph[y][x] == 0) {
                int[][] graphCp = new int[N][N];
                for (int idx = 0; idx < N; idx++) {
                    graphCp[idx] = graph[idx].clone();
                }

                for (int range = 1; range < N; range++) {
                    for (int idx = 0; idx < dx.length; idx++) {
                        int nx = x + dx[idx] * range;
                        int ny = y + dy[idx] * range;
                        if (isInside(nx, ny)) {
                            graphCp[ny][nx] = -1;
                        }
                    }
                }

                graphCp[y][x] = 5;
                calc(y + 1, graphCp);
            }
        }
    }

    static boolean isInside(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) {
            return false;
        }
        return true;
    }

    static void printGraph(int y, int[][] graph) {
        StringBuilder sb = new StringBuilder();
        sb.append("Case:").append(cnt).append('\n');
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(String.format("%3d", graph[i][j]));
            }
            sb.append('\n');
        }
        sb.append("-".repeat(3 * (N + 1)));
        System.out.println(sb);
    }
}