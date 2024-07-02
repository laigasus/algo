import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class P11403_2 {
    private static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        graph = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt() == 1;
            }
        }

        floyd(N);

        print(N);
    }

    private static void print(int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(graph[i][j] ? 1 : 0);
                sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static void floyd(int N) {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }
    }
}