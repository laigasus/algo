import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class P1197Kruskal {
    static int V, E;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] parent;

    static class Edge {
        int s, e, w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        V = readInt();
        E = readInt();

        parent = IntStream.rangeClosed(0, V).toArray();

        while (E-- > 0) {
            int a = readInt();
            int b = readInt();
            int c = readInt();

            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges, (e1, e2) -> e1.w - e2.w);

        System.out.println(kruskal());
    }

    private static int kruskal() {
        int rs = 0;

        for (Edge edge : edges) {
            if (find(edge.s) != find(edge.e)) {
                union(edge.s, edge.e);
                rs += edge.w;
            }
        }

        return rs;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
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
