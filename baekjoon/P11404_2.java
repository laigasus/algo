import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class P11404_2 {
    private static final int INF = 10_000_000;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        graph = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], INF);
        }

        while (M-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph[a][b] = Math.min(graph[a][b], c);
        }

        floyd(N);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j || graph[i][j] == INF) {
                    sb.append(0);
                } else {
                    sb.append(graph[i][j]);
                }
                sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    private static void floyd(int N) {
        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
    }

}