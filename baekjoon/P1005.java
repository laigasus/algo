import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P1005 {

    static class Node {
        int v, cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        int T = readInt();
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            sb.append(calc()).append('\n');
        }

        System.out.print(sb);
    }

    static int N, K;
    static List<List<Node>> graph;

    private static int calc() throws IOException {
        N = readInt();
        K = readInt();

        graph = new ArrayList<>();

        int[] cost = new int[N + 1];
        int[] indegree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            cost[i] = readInt();
        }

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (K-- > 0) {
            int a = readInt();
            int b = readInt();
            graph.get(a).add(new Node(b, cost[b]));
            indegree[b]++;
        }

        int end = readInt();

        return BFS(cost, indegree, end);
    }

    private static int BFS(int[] cost, int[] indegree, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n2.cost - n1.cost);
        int[] dp = new int[N + 1];

        for (int start = 1; start <= N; start++) {
            if (indegree[start] == 0) {
                dp[start] = cost[start];
                pq.offer(new Node(start, dp[start]));
            }
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : graph.get(now.v)) {
                dp[next.v] = Math.max(dp[next.v], dp[now.v] + cost[next.v]);
                indegree[next.v]--;

                if (indegree[next.v] == 0) {
                    pq.offer(new Node(next.v, dp[next.v]));
                }
            }
        }

        return dp[end];
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