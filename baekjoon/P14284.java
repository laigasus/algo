import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class P14284 {
    static int N, M;
    static List<List<Node>> graph = new ArrayList<>();

    static class Node {
        int v, c;

        public Node(int v, int c) {
            this.v = v;
            this.c = c;
        }

    }

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            int a = readInt();
            int b = readInt();
            int c = readInt();

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        int start = readInt();
        int end = readInt();

        System.out.println(dijkstra(start, end));
    }

    private static int dijkstra(int start, int end) {
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.c - n2.c);

        dist[start] = 0;

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            visited[now.v] = true;

            if (now.v == end) {
                break;
            }

            if (now.c > dist[now.v]) {
                continue;
            }

            for (Node next : graph.get(now.v)) {
                if (visited[next.v]) {
                    continue;
                }

                if (now.c + next.c < dist[next.v]) {
                    dist[next.v] = now.c + next.c;
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
