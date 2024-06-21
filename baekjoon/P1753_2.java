import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class P1753_2 {
    private static final int INF = Integer.MAX_VALUE;
    private static List<List<Point>> graph = new ArrayList<>();
    private static int V, E;
    private static int[] dist;
    private static boolean[] visited;

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

        V = sc.nextInt();
        E = sc.nextInt();

        init();

        int K = sc.nextInt();

        while (E-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new Point(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int start = 1; start <= V; start++) {
            sb.append(dist[start] == INF ? "INF" : dist[start]).append('\n');
        }

        System.out.print(sb);
    }

    private static void init() {
        dist = new int[V + 1];
        visited = new boolean[V + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
    }


    private static void dijkstra(int k) {
        Queue<Point> q = new PriorityQueue<>(Comparator.comparingInt(n -> n.w));

        q.offer(new Point(k, 0));
        dist[k] = 0;
        visited[k] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();
            visited[now.v] = true;

            for (Point next : graph.get(now.v)) {
                if (visited[next.v]) {
                    continue;
                }

                if (dist[now.v] + next.w < dist[next.v]) {
                    dist[next.v] = dist[now.v] + next.w;
                    q.offer(new Point(next.v, dist[next.v]));
                }
            }
        }
    }
}