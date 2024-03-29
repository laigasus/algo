import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P11724_1 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int N = readInt();
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

        int cnt = 0;

        for (int node = 1; node <= N; node++) {
            if (!visited[node]) {
                cnt++;
                visited[node] = true;
                dfs(node);
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int now) {
        for (int next : graph.get(now)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
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
