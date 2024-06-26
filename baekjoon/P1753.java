import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P1753 {

    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;

    static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

    }

    static int V, E;

    public static void main(String[] args) throws IOException {
        V = readInt();
        E = readInt();
        int K = readInt();

        dist = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        while (E-- > 0) {
            graph.get(readInt()).add(new Node(readInt(), readInt()));
        }

        dijkstra(K);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append('\n');
        }

        System.out.print(sb);
    }

    private static void dijkstra(int K) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);
        dist[K] = 0;

        pq.offer(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            visited[now.v] = true;

            if (now.w > dist[now.v]) {
                continue;
            }

            for (Node next : graph.get(now.v)) {
                if (visited[next.v]) {
                    continue;
                }

                if (now.w + next.w < dist[next.v]) {
                    dist[next.v] = now.w + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    private static int readInt() throws IOException {
        int rs = 0;
        boolean isNegative = false;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        if (c == '-') {
            isNegative = true;
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return isNegative ? -rs : rs;
    }
}