import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class P1197 {
    static int V, E;
    static List<ArrayList<Node>> graph;
    static int[] parent;

    static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        V = readInt();
        E = readInt();

        graph = Stream.generate(() -> new ArrayList<Node>()).limit(V + 1).collect(Collectors.toList());
        parent = IntStream.rangeClosed(1, V).toArray();

        while (E-- > 0) {
            int a = readInt();
            int b = readInt();
            int c = readInt();

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        System.out.println(prim(1));
    }

    private static int prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);
        boolean[] visited = new boolean[V + 1];
        int rs = 0;

        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.v]) {
                continue;
            }

            rs += now.w;
            visited[now.v] = true;

            for (Node next : graph.get(now.v)) {
                if (visited[next.v]) {
                    continue;
                }

                pq.offer(next);
            }
        }

        return rs;

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
