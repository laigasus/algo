import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P13023 {
    static final int FRIEND_CONDITION_NEEDS = 5;

    static boolean exists;
    static List<List<Integer>> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        final int N = readInt();
        int M = readInt();

        exists = false;
        list = new ArrayList<>();
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        while (M-- > 0) {
            int a = readInt();
            int b = readInt();

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int node = 0; node < N; node++) {
            dfs(node, 1);
            if (exists) {
                break;
            }
        }
        System.out.println(exists ? 1 : 0);
    }

    private static void dfs(int now, int depth) {
        if (depth == FRIEND_CONDITION_NEEDS) {
            exists = true;
            return;
        }

        visited[now] = true;
        for (int next : list.get(now)) {
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