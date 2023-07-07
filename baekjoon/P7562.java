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
    static boolean[][] visited;
    static int I;

    private static class Node {
        int x, y, cnt;

        Node(int x, int y, int cnt) {
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
        visited = new boolean[I][I];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());

        return bfs(new Node(x, y, 0), endX, endY);
    }

    static int bfs(Node start, int endX, int endY) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int cnt = node.cnt;
            visited[y][x] = true;

            if (x == endX && y == endY) {
                return cnt;
            }

            int nx, ny;
            for (int i = 0; i < 8; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx < 0 || nx >= I || ny < 0 || ny >= I) {
                    continue;
                }

                if (!visited[ny][nx]) {
                    queue.offer(new Node(nx, ny, cnt + 1));
                    visited[ny][nx] = true;
                }
            }
        }

        return -1;
    }
}