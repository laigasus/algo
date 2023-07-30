import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P11725 {
    static List<List<Integer>> graph = new ArrayList<>();
    static int parent[];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int N = readInt();
        parent = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int a = readInt();
            int b = readInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);

        for (int i = 2; i < parent.length; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.print(sb);

    }

    static void dfs(int start) {
        for (int node : graph.get(start)) {
            if (parent[node] == 0) {
                parent[node] = start;
                dfs(node);
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