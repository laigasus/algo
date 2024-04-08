import java.io.IOException;
import java.util.ArrayList;

public class P1325 {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] trusted;

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            int a = readInt();
            int b = readInt();

            graph[b].add(a);
        }

        trusted = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, trusted[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (trusted[i] == max) {
                sb.append(i).append(' ');
            }
        }

        System.out.println(sb);
    }

    private static void dfs(int start, int now) {
        visited[now] = true;

        for (int next : graph[now]) {
            if (!visited[next]) {
                trusted[start]++;
                dfs(start, next);
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
