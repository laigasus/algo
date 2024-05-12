
import java.util.Scanner;

class S1979 {
    static int[][] board;
    static int N, K;
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            K = sc.nextInt();
            board = new int[N][N];

            init();
            int result = 0;
            for (int i = 0; i < N; i++) {
                result += searchV(i) + searchH(i);
            }

            sb.append(String.format("#%d %d\n", test_case, result));
        }
        System.out.println(sb);
    }

    private static int searchV(int x) {
        int[] lengths = new int[N + 1];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (board[i][x] == 0) {
                if (cnt > 0) {
                    lengths[cnt]++;
                }
                cnt = 0;
            } else {
                cnt++;
            }
        }
        if (cnt > 0)
            lengths[cnt]++;

        return lengths[K];
    }

    private static int searchH(int y) {
        int[] lengths = new int[N + 1];
        int cnt = 0;
        for (int j = 0; j < N; j++) {
            if (board[y][j] == 0) {
                if (cnt > 0) {
                    lengths[cnt]++;
                }
                cnt = 0;
            } else {
                cnt++;
            }
        }
        if (cnt > 0)
            lengths[cnt]++;

        return lengths[K];
    }

    private static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
    }
}