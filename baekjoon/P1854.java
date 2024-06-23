import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1854 {
    private static int N, M, K;
    private static PriorityQueue<Integer>[] dist;

    private static final List<List<Node>> graph = new ArrayList<>();

    private static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new PriorityQueue[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            dist[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        dijkstra(new Node(1, 0));

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (dist[i].size() == K) {
                sb.append(dist[i].peek());
            } else {
                sb.append(-1);
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static void dijkstra(Node start) {
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(p -> p.w));

        q.offer(start);
        dist[start.v].offer(0);

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (Node next : graph.get(now.v)) {
                if (dist[next.v].size() < K || dist[next.v].peek() > now.w + next.w) {
                    if (dist[next.v].size() == K) {
                        dist[next.v].poll();
                    }

                    dist[next.v].offer(now.w + next.w);
                    q.offer(new Node(next.v, now.w + next.w));
                }
            }
        }
    }
}