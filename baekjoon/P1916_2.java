import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class P1916_2 {
    private static final int INF = Integer.MAX_VALUE;
    private static int[] dist;
    private static boolean[] visited;

    private static final List<List<Point>> graph = new ArrayList<>();

    private static class Point {
        int v, w;

        public Point(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }


        while (m-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new Point(v, w));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        sc.close();

        dijkstra(start, end);

        System.out.println(dist[end]);
    }

    private static void dijkstra(int start, int end) {
        Queue<Point> q = new PriorityQueue<>(Comparator.comparing(point -> point.w));

        q.offer(new Point(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Point now = q.poll();
            visited[now.v] = true;

            if (now.v == end) {
                break;
            }

            for (Point next : graph.get(now.v)) {
                if (visited[next.v]) {
                    continue;
                }

                if (dist[next.v] > dist[now.v] + next.w) {
                    dist[next.v] = dist[now.v] + next.w;

                    q.offer(new Point(next.v, dist[next.v]));
                }
            }
        }
    }
}