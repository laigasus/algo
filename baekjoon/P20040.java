import java.io.IOException;
import java.util.stream.IntStream;

public class P20040 {
    static int[] parent;
    static int N;

    public static void main(String[] args) throws IOException {
        N = readInt();
        int M = readInt();

        parent = IntStream.rangeClosed(0, N - 1).toArray();

        System.out.println(findFirstCycle(M));
    }

    private static int findFirstCycle(int M) throws IOException {
        int rs = 0;
        for (int t = 1; t <= M; t++) {
            int a = readInt();
            int b = readInt();

            if (rs != 0) {
                continue;
            }

            if (find(a) == find(b)) {
                rs = t;
            } else {
                union(a, b);
            }
        }
        return rs;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
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