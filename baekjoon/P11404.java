import java.io.IOException;
import java.util.Arrays;

public class P11404 {

    static int graph[][];
    static final int INF = 987_654_321;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int n = readInt(), m = readInt();

        graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        while (m-- > 0) {
            int a = readInt();
            int b = readInt();
            int c = readInt();

            graph[a][b] = Math.min(graph[a][b], c);
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || graph[i][j] == INF) {
                    sb.append(0);
                } else {
                    sb.append(graph[i][j]);
                }
                sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }
}