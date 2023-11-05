import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class P1238FloydWashall {

    static int N, M, X;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();
        X = readInt();

        graph = new int[N + 1][N + 1];
        for (int[] row : graph) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 1; i <= N; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            int a = readInt();
            int b = readInt();
            int c = readInt();

            graph[a][b] = c;
        }

        floydWarshall();

        int[] ranges = new int[N + 1];

        for (int start = 1; start <= N; start++) {
            ranges[start] = graph[start][X] + graph[X][start];
        }

        System.out.println(IntStream.of(ranges).max().getAsInt());
    }

    private static void floydWarshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
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
