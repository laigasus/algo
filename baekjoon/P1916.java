import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P1916 {
    static int N, M;
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

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();

        dist = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        while (M-- > 0) {
            int a = readInt();
            int b = readInt();
            int c = readInt();

            graph.get(a).add(new Node(b, c));
        }

        int start = readInt();
        int end = readInt();

        System.out.println(dijkstra(start, end));
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            visited[now.v] = true;

            if (now.v == end) {
                break;
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

        return dist[end];

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
