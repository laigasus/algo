import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P11657 {
    static long dist[];
    static List<Node> graph;
    static final int INF = Integer.MAX_VALUE;
    static int N, M;

    static class Node {
        int s, e, w;

        public Node(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        dist = new long[N + 1];

        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.add(new Node(A, B, C));
        }

        if (bellmanFord(1)) {
            sb.append("-1").append('\n');
        } else {
            for (int i = 2; i < dist.length; i++) {
                sb.append(dist[i] == INF ? "-1" : dist[i]).append('\n');
            }
        }

        System.out.print(sb);
    }

    static boolean bellmanFord(int start) {
        dist[start] = 0;

        for (int now = start; now <= N; now++) {
            for (Node node : graph) {
                if (dist[node.s] == INF) {
                    continue;
                }
                if (dist[node.e] > dist[node.s] + node.w) {
                    dist[node.e] = dist[node.s] + node.w;
                }
            }
        }

        for (Node node : graph) {
            if (dist[node.s] == INF) {
                continue;
            }
            if (dist[node.e] > dist[node.s] + node.w) {
                return true;
            }
        }

        return false;
    }
}