import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class P1389 {
    private static final int INF = 100;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        int N, M;

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N + 1][N + 1];
        int[] kevin = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], INF);
            kevin[i] = INF;
        }

        while (M-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        floyd(N);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            kevin[i] = sum(graph[i]);
            min = Math.min(min, kevin[i]);
        }

        for (int index = 1; index <= N; index++) {
            if (min == kevin[index]) {
                System.out.println(index);
                return;
            }
        }
    }

    private static int sum(int[] ints) {
        int sum = 0;

        for (int n : ints) {
            if (n == INF) {
                continue;
            }

            sum += n;
        }

        return sum;
    }

    private static void floyd(int N) {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }
}