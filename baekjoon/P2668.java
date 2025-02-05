import java.io.IOException;
import java.util.TreeSet;

public class P2668 {
    private static int N;
    private static int[] graph;
    private static boolean[] visited;
    private static TreeSet<Integer> cycles;

    public static void main(String[] args) throws IOException {
        N = readInt();
        visited = new boolean[N + 1];
        graph = new int[N + 1];
        cycles = new TreeSet<>();

        for (int start = 1; start <= N; start++) {
            int end = readInt();
            graph[start] = end;
        }

        for (int num = 1; num <= N; num++) {
            visited = new boolean[N + 1];
            dfs(num, num);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cycles.size()).append('\n');
        cycles.forEach(c -> sb.append(c).append('\n'));

        System.out.print(sb);
    }

    public static void dfs(int now, int target) {
        visited[now] = true;
        int next = graph[now];
        if (!visited[next]) {
            dfs(next, target);
        } else if (next == target) {
            cycles.add(target);
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
