import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1697 {
    static int N, K;
    static boolean[] visited;
    static int MAX_POINT;
    static int cost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        MAX_POINT = Math.min(Math.max(N, K) * 2, 100_000);
        visited = new boolean[MAX_POINT + 1];

        moveShortestPath(N);

        System.out.println(cost);
    }

    private static class Point {
        int v, w;

        Point(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static void moveShortestPath(int start) {
        Queue<Point> path = new LinkedList<>();
        path.offer(new Point(start, 0));

        while (!path.isEmpty()) {
            Point point = path.poll();
            visited[point.v] = true;

            if (point.v == K) {
                cost = Math.min(cost, point.w);
                return;
            }

            int[] moves = { point.v * 2, point.v - 1, point.v + 1 };
            for (int next : moves) {
                if (next >= 0 && next <= MAX_POINT && !visited[next]) {
                    path.offer(new Point(next, point.w + 1));
                }
            }
        }
    }
}