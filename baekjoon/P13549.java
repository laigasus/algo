import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13549 {
    static int subin, bro, time = Integer.MAX_VALUE;
    static boolean[] visited;
    static int MAX_POINT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        subin = Integer.parseInt(st.nextToken());
        bro = Integer.parseInt(st.nextToken());

        MAX_POINT = Math.min(Math.max(subin, bro) * 2, 100_000);
        visited = new boolean[MAX_POINT + 1];

        bfs(subin);
        System.out.println(time);
    }

    static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static void bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            visited[now.v] = true;

            if (now.v == bro) {
                time = Math.min(time, now.w);
            }

            int next = now.v * 2;
            if (now.v * 2 <= MAX_POINT && !visited[next]) {
                q.offer(new Node(next, now.w));
            }

            next = now.v - 1;
            if (next >= 0 && !visited[next]) {
                q.offer(new Node(next, now.w + 1));
            }

            next = now.v + 1;
            if (next <= MAX_POINT && !visited[next]) {
                q.offer(new Node(next, now.w + 1));
            }
        }
    }
}