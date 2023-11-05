import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class P1238Dijkstra {

    static int N, M, X;
    static List<List<Node>> graph = new ArrayList<>();

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
        X = readInt();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = readInt();
            int b = readInt();
            int c = readInt();

            graph.get(a).add(new Node(b, c));
        }

        int[] ranges = new int[N + 1];

        for (int start = 1; start <= N; start++) {
            ranges[start] = dijkstra(start, X) + dijkstra(X, start);
        }

        System.out.println(IntStream.of(ranges).max().getAsInt());
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);
        int[] dist = IntStream.generate(() -> Integer.MAX_VALUE).limit(N + 1).toArray();
        boolean[] visited = new boolean[N + 1];

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.v == end) {
                break;
            }

            if (now.w > dist[now.v]) {
                continue;
            }

            for (Node next : graph.get(now.v)) {

                if (now.w + next.w < dist[next.v]) {
                    dist[next.v] = now.w + next.w;
                    visited[next.v] = true;
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
