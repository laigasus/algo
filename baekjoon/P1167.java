import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P1167 {
    static List<List<Node>> graph = new ArrayList<>();
    static int V;
    static int[] dist;
    static boolean[] visited;
    static int longestLen = 0, farthestNode = 1;

    public static void main(String[] args) throws IOException {
        V = readInt();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int repeat = 1; repeat <= V; repeat++) {
            int v, w;
            int node = readInt();
            while ((v = readInt()) != -1) {
                w = readInt();

                graph.get(node).add(new Node(v, w));
            }
        }

        calc(1);
        calc(farthestNode);

        System.out.println(longestLen);
    }

    private static void calc(int startNode) {
        visited = new boolean[V + 1];
        dist = new int[V + 1];
        visited[startNode] = true;

        dfs(new Node(startNode, 0));
    }

    private static void dfs(Node now) {
        if (longestLen < now.w) {
            longestLen = now.w;
            farthestNode = now.v;
        }

        for (var next : graph.get(now.v)) {
            if (!visited[next.v]) {
                visited[next.v] = true;
                dfs(new Node(next.v, next.w + now.w));
            }
        }
    }

    private static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
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
