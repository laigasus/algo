import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P11657_2 {
    private static int N, M;
    private static final int INF = Integer.MAX_VALUE;
    private static List<Node> graph;
    private static long[] dist;

    private static class Node {
        int start, end, w;

        public Node(int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        dist = new long[N + 1];
        graph = new ArrayList<>();

        Arrays.fill(dist, INF);

        while (M-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();

            graph.add(new Node(A, B, C));
        }

        bellmanFord();
        StringBuilder sb = new StringBuilder();

        if (isCycle()) {
            sb.append(-1);
        } else {
            for (int end = 2; end <= N; end++) {
                sb.append(dist[end] == INF ? -1 : dist[end]).append('\n');
            }
        }

        System.out.print(sb);
    }

    private static void bellmanFord() {
        dist[1] = 0;

        for (int i = 1; i < N; i++) {
            for (Node node : graph) {
                if (dist[node.start] == INF) {
                    continue;
                }

                if (dist[node.end] > dist[node.start] + node.w) {
                    dist[node.end] = dist[node.start] + node.w;
                }
            }
        }
    }

    private static boolean isCycle() {
        for (Node node : graph) {
            if (dist[node.start] != INF && dist[node.end] > dist[node.start] + node.w) {
                return true;
            }
        }

        return false;
    }
}