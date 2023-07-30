import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P11724 {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();

        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            int u = readInt();
            int v = readInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int cnt = 0;
        for (int node = 1; node <= N; node++) {
            if (!visited[node]) {
                cnt++;
                calc(node);
            }
        }

        System.out.println(cnt);
    }

    static void calc(int now) {
        visited[now] = true;

        for (int next : graph.get(now)) {
            if (!visited[next]) {
                calc(next);
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