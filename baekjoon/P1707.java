import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P1707 {
    static final List<List<Integer>> graph = new ArrayList<>();
    static final Stack<Integer> stk = new Stack<>();

    static int V, E;
    static StringBuilder sb = new StringBuilder();
    static Boolean[] chk = new Boolean[V + 1];

    public static void main(String[] args) throws IOException {
        int K = readInt();
        while (K-- > 0) {
            init();
            calc();
        }

        System.out.print(sb);
    }

    static void init() throws IOException {
        V = readInt();
        E = readInt();

        graph.clear();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        while (E-- > 0) {
            int a = readInt();
            int b = readInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

    static void calc() {
        boolean rs = true;
        chk = new Boolean[V + 1];// 색이 칠해진 것(true, false), 칠해지지 않는 것(null) 분류

        for (int start = 1; start <= V; start++) {
            if (!isPossible(start, chk)) {
                rs = false;
                break;
            }
        }

        sb.append(rs ? "YES" : "NO").append('\n');
    }

    private static boolean isPossible(int start, Boolean[] chk) {
        if (chk[start] != null) {
            return true;
        }
        stk.clear();

        stk.add(start);
        chk[start] = true;

        while (!stk.isEmpty()) {
            int now = stk.pop();
            for (int next : graph.get(now)) {
                if (chk[next] == null) {
                    chk[next] = !chk[now];
                    stk.add(next);
                } else if (chk[next] == chk[now]) {
                    return false;
                }
            }
        }

        return true;
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