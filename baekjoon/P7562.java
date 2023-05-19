import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dx = { -1, 1, 2, 2, 1, -1, -2, -2 };
    static int[] dy = { -2, -2, -1, 1, 2, 2, 1, -1 };
    static int[][] graph;
    static int I;
    static int endX, endY;

    static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            sb.append(getMinMove()).append('\n');
        }

        System.out.print(sb);

    }

    static int getMinMove() throws IOException {
        StringTokenizer st;

        I = Integer.parseInt(br.readLine());
        graph = new int[I][I];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());

        bfs(new Node(x, y, 0));

        return graph[endY][endX];
    }

    static void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int cnt = node.cnt;

            if (x == endX && y == endY) {
                graph[endY][endX] = cnt;
                return;
            }

            int nx, ny;
            for (int i = 0; i < 8; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx < 0 || nx >= I || ny < 0 || ny >= I) {
                    continue;
                }

                if (graph[ny][nx] == 0) {
                    queue.offer(new Node(nx, ny, cnt + 1));
                    graph[ny][nx] = cnt + 1;
                }
            }
        }
    }
}