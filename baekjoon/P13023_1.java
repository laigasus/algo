import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P13023_1 {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static final int NEED_FRIENDS = 5;
    static int exists = 0;

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

        for (int start = 0; start < N; start++) {
            dfs(start, 1);
        }

        System.out.println(0);
    }

    private static void dfs(int now, int depth) {
        if (depth == NEED_FRIENDS) {
            System.out.println(1);
            System.exit(0);
        }

        visited[now] = true;
        for (var next : graph.get(now)) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
        visited[now] = false;
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
