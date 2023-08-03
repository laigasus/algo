import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringJoiner;

public class P1260 {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static StringJoiner sj;
    static int N, M, V;

    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        dfs(V);

        sb.append('\n');

        init();
        bfs(V);

        System.out.println(sb);
    }

    static void init() throws IOException {
        if (graph != null) {
            visited = new boolean[N + 1];
            return;
        }

        N = readInt();
        M = readInt();
        V = readInt();

        visited = new boolean[N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            int a = readInt();
            int b = readInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        graph.forEach(list -> Collections.sort(list));
    }

    static void dfs(int now) {
        visited[now] = true;
        sb.append(now).append(' ');

        for (int next : graph.get(now)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(' ');

            for (int next : graph.get(now)) {
                if (visited[next]) {
                    continue;
                }
                q.offer(next);
                visited[next] = true;
            }
        }
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