import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
    static Queue<Node> queue = new LinkedList<>();
    static int[][] graph;
    static int N, M;
    // 이동방향 정의
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    final static int directionPoint = 4;

    private static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y) {
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.x;
            y = node.y;

            // 이동방향(동,서,남,북 +1)
            for (int i = 0; i < directionPoint; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                // 범위 밖인 경우
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                // 벽이 존재하는 경우
                if (graph[nx][ny] == 0) {
                    continue;
                }

                // 한번도 지나지 않은 곳일 경우
                if (graph[nx][ny] == 1) {
                    // 누적 이동수를 그래프에 기록
                    graph[nx][ny] = graph[x][y] + 1;
                    queue.add(new Node(nx, ny));
                }
            }
        }

        // 종착지의 누적 이동수 출력
        return graph[N - 1][M - 1];
    }
}