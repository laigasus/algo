import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P11724 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        final int N = readInt();
        int M = readInt();

        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            int a = readInt();
            int b = readInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int result = 0;
        for (int node = 1; node <= N; node++) {
            if (!visited[node]) {
                result++;
                DFS(node);
            }
        }

        System.out.println(result);
    }

    private static void DFS(int now) {
        visited[now] = true;

        for (var next : graph.get(now)) {
            if (!visited[next]) {
                DFS(next);
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