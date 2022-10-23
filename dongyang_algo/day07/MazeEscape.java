package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Queue 에 사용될 Node 클래스
class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class MazeEscape {
    public static int n, m;
    public static int[][] graph = new int[201][201];

    // 이동방향 정의
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n, m 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // BFS 수행 결과 출력
        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        // Queue 구현을 위해 Queue 라이브러리 사용
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(x, y));

        // 큐가 빌 때 까지
        while (!q.isEmpty()) {
            Node node = q.remove();
            x = node.getX();
            y = node.getY();
            // 4 방향 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 범위 밖인 경우
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                // 괴물(벽)이 존재하는 경우
                if (graph[nx][ny] == 0) {
                    continue;
                }
                // 이동 가능한 경우
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.add(new Node(nx, ny));
                }
            }
        }
        // 탈출구(우측 최하단 위치)까지의 최단거리 반환
        return graph[n - 1][m - 1];
    }
}