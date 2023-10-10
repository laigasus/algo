import java.io.IOException;

public class P1976 {
    static int[] parent;
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int isConnected = readInt();

                if (isConnected == 1) {
                    union(i, j);
                }
            }
        }

        System.out.println(calc(find(readInt())) ? "YES" : "NO");
    }

    private static boolean calc(int start) throws IOException {
        for (int i = 1; i < M; i++) {
            int now = readInt();
            if (start != (find(now))) {
                return false;
            }
        }

        return true;
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[x] = y;
        }
    }

    private static int find(int x) {
        if (x == parent[x]) {// root 노드
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