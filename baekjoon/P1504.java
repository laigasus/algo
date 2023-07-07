import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class P1504 {
    private static class Node {
        int v;
        int c;

        Node(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

    static List<List<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] dp;
    static int N, E;
    static int V1, V2;
    static final int INF = 200_000_001;

    public static void main(String[] args) throws IOException {
        int rs = INF;
        N = readInt();
        E = readInt();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        while (E-- > 0) {
            int a = readInt(), b = readInt(), c = readInt();

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        V1 = readInt();
        V2 = readInt();

        dijkstra(1);
        int sToV1 = dp[V1];
        int sToV2 = dp[V2];

        dijkstra(V1);
        int V1ToV2 = dp[V2];
        int V1ToN = dp[N];

        dijkstra(V2);
        int V2ToV1 = dp[V1];
        int V2ToN = dp[N];

        rs = Math.min(rs, sToV1 + V1ToV2 + V2ToN);
        rs = Math.min(rs, sToV2 + V2ToV1 + V1ToN);

        System.out.println(rs >= INF ? -1 : rs);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.c - n2.c);
        pq.offer(new Node(start, 0));
        visited = new boolean[N + 1];
        dp = new int[N + 1];
        Arrays.fill(dp, INF);

        dp[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            visited[now.v] = true;

            for (Node next : graph.get(now.v)) {
                if (!visited[next.v] && dp[next.v] > now.c + next.c) {
                    dp[next.v] = now.c + next.c;
                    pq.offer(new Node(next.v, dp[next.v]));
                }
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }
}