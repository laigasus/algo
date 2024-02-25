import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class P1260F {
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        final int N = readInt(), M = readInt(), V = readInt();

        init(N, M);

        StringBuilder sb = new StringBuilder();
        sb.append(DFS(N, V)).append('\n');
        sb.append(BFS(N, V)).append('\n');

        System.out.print(sb);
    }

    private static String DFS(final int N, final int V) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N + 1];

        stack.push(V);
        visited[V] = true;
        sb.append(V).append(' ');

        while (!stack.isEmpty()) {

            int now = stack.peek();
            boolean flag = false;

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    stack.push(next);
                    sb.append(next).append(' ');
                    flag = true;
                    visited[next] = true;

                    break;
                }
            }

            if (!flag) {
                stack.pop();
            }
        }

        return sb.toString();
    }

    private static String BFS(final int N, final int V) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(' ');

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        return sb.toString();
    }

    private static void init(int n, int m) throws IOException {
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = readInt();
            int b = readInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        graph.forEach(list -> Collections.sort(list));
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