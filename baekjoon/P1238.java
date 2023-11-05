import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class P1238 {
    static int N, M, X;

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

        List<ArrayList<Node>> graph1, graph2;
        graph1 = generateGraph();
        graph2 = generateGraph();

        for (int i = 0; i < M; i++) {
            int a = readInt();
            int b = readInt();
            int c = readInt();

            graph1.get(a).add(new Node(b, c));
            graph2.get(b).add(new Node(a, c));
        }

        int[] dist1 = dijkstra(graph1);
        int[] dist2 = dijkstra(graph2);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dist1[i] + dist2[i]);
        }

        System.out.println(max);
    }

    private static List<ArrayList<Node>> generateGraph() {
        return Stream.generate(() -> new ArrayList<Node>())
                .limit(N + 1)
                .collect(Collectors.toList());
    }

    private static int[] dijkstra(List<ArrayList<Node>> graph) {
        Queue<Node> queue = new LinkedList<>();
        int[] dist = IntStream.generate(() -> Integer.MAX_VALUE).limit(N + 1).toArray();

        dist[X] = 0;
        queue.offer(new Node(X, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.w > dist[now.v]) {
                continue;
            }

            for (Node next : graph.get(now.v)) {
                if (now.w + next.w < dist[next.v]) {
                    dist[next.v] = now.w + next.w;
                    queue.offer(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist;
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
