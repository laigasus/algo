import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2667 {
    static int[][] graph;
    static boolean[][] visited;
    static int N, cnt = 0;
    static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
    static List<Integer> homes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                dfs(i, j);
                homes.add(cnt);
                cnt = 0;
            }
        }

        Collections.sort(homes);

        sb.append(homes.size()).append('\n');
        homes.forEach(n -> sb.append(n).append('\n'));

        System.out.print(sb);
    }

    static void dfs(int y, int x) {
        cnt++;
        visited[y][x] = true;
        int nx, ny;

        for (int i = 0; i < dx.length; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if (graph[ny][nx] == 1 && !visited[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }
}