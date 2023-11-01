import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P1939 {

    static int N, M;
    static List<ArrayList<Node>> graph;

    static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

    }

    static final int MAX_LEN = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();

        int left = MAX_LEN;
        int right = Integer.MIN_VALUE;

        graph = Stream.generate(() -> {
            return new ArrayList<Node>();
        }).limit(N + 1).collect(Collectors.toList());

        for (int i = 0; i < M; i++) {
            int A = readInt();
            int B = readInt();
            int C = readInt();

            left = Math.min(left, C);
            right = Math.max(right, C);

            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }

        int start = readInt();
        int end = readInt();

        int rs = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (bfs(start, end, mid)) {
                left = mid + 1;
                rs = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(rs);
    }

    private static boolean bfs(int start, int end, int freight) {
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);
        boolean[] visited = new boolean[N + 1];

        queue.offer(new Node(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.v == end) {
                return true;
            }

            for (Node next : graph.get(now.v)) {
                if (visited[next.v]) {
                    continue;
                }

                if (freight <= next.w) {
                    visited[next.v] = true;
                    queue.offer(new Node(next.v, next.w));
                }
            }
        }

        return false;
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
