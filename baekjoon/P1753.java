import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753 {
    static List<List<Node>> graph;
    static int[] dp;
    static boolean[] visited;
    final static int INF = 200_000;

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        dp = new int[V + 1];
        visited = new boolean[V + 1];

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            dp[i] = INF;
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            sb.append(dp[i] == INF ? "INF" : dp[i]).append('\n');
        }

        System.out.print(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);
        q.offer(new Node(start, 0));
        dp[start] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            visited[now.v] = true;

            for (Node next : graph.get(now.v)) {
                if (!visited[next.v] && dp[next.v] > now.w + next.w) {
                    dp[next.v] = now.w + next.w;
                    q.offer(new Node(next.v, dp[next.v]));
                }
            }
        }
    }
}