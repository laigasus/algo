import java.io.IOException;
import java.util.stream.IntStream;

public class P1717 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = readInt(), m = readInt();

        parent = IntStream.rangeClosed(0, n).toArray();

        while (m-- > 0) {
            int task = readInt();
            int a = readInt(), b = readInt();

            if (task == 0) {
                union(a, b);
            } else if (task == 1) {
                sb.append(chkSameParent(a, b) ? "YES" : "NO").append('\n');
            }
        }

        System.out.print(sb);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static boolean chkSameParent(int a, int b) {
        if (find(a) == find(b)) {
            return true;
        }
        return false;
    }

    private static int find(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
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