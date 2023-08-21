import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P1967 {

    static List<List<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int N, maxWeight = 0;

    static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        N = readInt();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int parent = readInt();
            int child = readInt();
            int weight = readInt();
            graph.get(parent).add(new Node(child, weight));
            graph.get(child).add(new Node(parent, weight));
        }

        maxWeight = getMaxWeight(1);
        maxWeight = getMaxWeight(lastNode);

        System.out.println(maxWeight);
    }

    private static int getMaxWeight(int start) {
        visited = new boolean[N + 1];
        dfs(start, 0);
        return Math.max(maxWeight, totalW);
    }

    static int totalW = 0, lastNode = 0;

    private static void dfs(int now, int weight) {
        visited[now] = true;

        for (Node next : graph.get(now)) {
            if (visited[next.v]) {
                continue;
            }
            dfs(next.v, weight + next.w);
        }

        if (weight > totalW) {
            totalW = weight;
            lastNode = now;
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