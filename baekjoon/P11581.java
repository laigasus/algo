import java.io.IOException;

public class P11581 {
    static int N, M;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        N = readInt();
        visited = new boolean[N + 1][N + 1];

        for (int node = 1; node < N; node++) {
            int crossroads = readInt();

            while (crossroads-- > 0) {
                visited[node][readInt()] = true;
            }
        }

        for (int k = 1; k < N; k++) {
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (visited[i][k] && visited[k][j]) {
                        visited[i][j] = true;
                    }
                }
            }
        }

        System.out.println(isCycle() ? "CYCLE" : "NO CYCLE");
    }

    private static boolean isCycle() {
        for (int i = 1; i < N; i++) {
            if (visited[1][i] && visited[i][i]) {
                return true;
            }
        }
        return false;
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
