import java.io.FileInputStream;
import java.util.Scanner;

class S1961 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + "\n");

            int N = sc.nextInt();

            int[][] board = init(N, sc);

            int[][] rotated90 = rotate(board, N);
            int[][] rotated180 = rotate(rotated90, N);
            int[][] rotated270 = rotate(rotated180, N);

            int[][][] rotates = { rotated90, rotated180, rotated270 };

            for (int i = 0; i < N; i++) {
                for (int[][] rotate : rotates) {
                    for (int j = 0; j < N; j++) {
                        sb.append(rotate[i][j]);
                    }
                    sb.append(' ');
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }

    private static int[][] init(int N, Scanner sc) {
        int[][] dest = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dest[i][j] = sc.nextInt();
            }
        }

        return dest;
    }

    private static int[][] rotate(int[][] target, int N) {
        int[][] rotated = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotated[i][j] = target[N - 1 - j][i];
            }
        }

        return rotated;
    }
}