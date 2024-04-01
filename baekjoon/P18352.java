import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P18352 {
    static List<List<Integer>> graph = new ArrayList<>();
    static int N, M, K, X;

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();
        K = readInt();
        X = readInt();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            int a = readInt();
            int b = readInt();

            graph.get(a).add(b);
        }

        var result = bfs(new Node(X, 0));

        StringBuilder sb = new StringBuilder();

        if (result.isEmpty()) {
            sb.append(-1);
        } else {
            Collections.sort(result, Comparator.naturalOrder());

            result.forEach(e -> {
                sb.append(e).append('\n');
            });
        }

        System.out.print(sb);
    }

    private static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private static List<Integer> bfs(Node start) {
        boolean[] visited = new boolean[N + 1];
        List<Integer> result = new ArrayList<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.v] = true;

        while (!queue.isEmpty()) {
            var now = queue.poll();

            if (now.w == K) {
                dist[now.v] = Math.min(now.w, dist[now.v]);
                continue;
            }

            for (var next : graph.get(now.v)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Node(next, now.w + 1));
                }
            }
        }

        for (int node = 1; node <= N; node++) {
            if (dist[node] == K) {
                result.add(node);
            }
        }

        return result;
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
