import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1219 {
    private static final int MAX_CITY = 50;
    private static List<Node> graph;
    private static int N, start, end, M;
    private static long[] dist;
    private static long[] earn;


    private static class Node {
        int start, end;
        int w;

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
        start = sc.nextInt();
        end = sc.nextInt();
        M = sc.nextInt();

        dist = new long[N];
        earn = new long[N];
        Arrays.fill(dist, Long.MIN_VALUE);

        graph = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            graph.add(new Node(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        for (int i = 0; i < N; i++) {
            earn[i] = sc.nextLong();
        }

        bellmanFord(start);

        StringBuilder sb = new StringBuilder();
        if (dist[end] == Long.MIN_VALUE) {
            sb.append("gg");
        } else if (dist[end] == Long.MAX_VALUE) {
            sb.append("Gee");
        } else {
            sb.append(dist[end]);
        }

        System.out.println(sb);
    }

    private static void bellmanFord(int start) {
        dist[start] = earn[start];

        for (int i = 0; i <= N + MAX_CITY; i++) {
            for (Node node : graph) {
                if (dist[node.start] == Long.MIN_VALUE) {
                    continue;
                }

                if (dist[node.start] == Long.MAX_VALUE) {
                    dist[node.end] = Long.MAX_VALUE;
                } else if (dist[node.end] < dist[node.start] - node.w + earn[node.end]) {
                    dist[node.end] = dist[node.start] - node.w + earn[node.end];

                    if (i >= N - 1) {
                        dist[node.end] = Long.MAX_VALUE;
                    }
                }
            }
        }
    }
}