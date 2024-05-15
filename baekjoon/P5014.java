import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class P5014 {
    static boolean[] visited;
    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 건물 층수
        F = Integer.parseInt(st.nextToken());
        visited = new boolean[F + 1];

        // 현재 층
        S = Integer.parseInt(st.nextToken());

        // 목적지 G
        G = Integer.parseInt(st.nextToken());

        // 위로 U
        U = Integer.parseInt(st.nextToken());

        // 아래로 D
        D = Integer.parseInt(st.nextToken());

        int result = bfs(S);
        System.out.println(result == -1 ? "use the stairs" : result);
    }

    private static class Point {
        int floor, cost;

        public Point(int floor, int cost) {
            this.floor = floor;
            this.cost = cost;
        }
    }

    private static int bfs(int start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.floor == G) {
                return now.cost;
            }

            for (int next : new int[] { now.floor + U, now.floor - D }) {
                if (!isInside(next)) {
                    continue;
                }

                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new Point(next, now.cost + 1));
                }
            }
        }

        return -1;
    }

    private static boolean isInside(int next) {
        return 1 <= next && next <= F;
    }

}