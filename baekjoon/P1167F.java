import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P1167F {
    private static class Node {
        int v, len;

        public Node(int v, int len) {
            this.v = v;
            this.len = len;
        }
    }

    static int V;
    static int[] dist;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        V = readInt();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            int v, len;
            int node = readInt();

            while ((v = readInt()) != -1) {
                len = readInt();

                graph.get(node).add(new Node(v, len));
            }
        }

        int maxNode = bfs(new Node(1, 0));
        maxNode = bfs(new Node(maxNode, 0));

        System.out.println(dist[maxNode]);
    }

    private static int bfs(Node start) {
        int max = 0, maxLenNode = start.v;
        Queue<Node> queue = new LinkedList<>();

        dist = new int[V + 1];
        boolean[] visited = new boolean[V + 1];

        queue.offer(start);
        visited[start.v] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (Node next : graph.get(now.v)) {
                if (visited[next.v]) {
                    continue;
                }

                dist[next.v] = dist[now.v] + next.len;
                visited[next.v] = true;
                queue.offer(next);

                if (dist[next.v] >= max) {
                    max = dist[next.v];
                    maxLenNode = next.v;
                }
            }
        }

        return maxLenNode;
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