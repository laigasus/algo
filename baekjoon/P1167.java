import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1167 {
    static List<List<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;
    static int V;

    static class Node {
        int v, len;

        public Node(int v, int len) {
            this.v = v;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) {
                    break;
                }
                int len = Integer.parseInt(st.nextToken());

                graph.get(now).add(new Node(v, len));
            }
        }

        int maxLenNode = bfs(new Node(1, 0));
        maxLenNode = bfs(new Node(maxLenNode, 0));

        System.out.println(dist[maxLenNode]);
    }

    static int bfs(Node start) {
        int max = 0, maxLenNode = 1;
        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[V + 1];
        dist = new int[V + 1];
        queue.offer(start);

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            visited[now.v] = true;

            for (Node next : graph.get(now.v)) {
                if (!visited[next.v]) {
                    dist[next.v] = dist[now.v] + next.len;
                    queue.offer(next);

                    if (dist[next.v] >= max) {
                        max = dist[next.v];
                        maxLenNode = next.v;
                    }
                }
            }
        }

        return maxLenNode;
    }
}