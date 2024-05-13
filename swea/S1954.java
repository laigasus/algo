import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class S1954 {
    static final int[] DX = { 1, 0, -1, 0 };
    static final int[] DY = { 0, 1, 0, -1 };

    static int[][] board;
    static int N;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + "\n");

            N = sc.nextInt();
            board = new int[N][N];

            fill(0, 0, 1, 0);

            sb.append(print());
        }

        System.out.println(sb);
    }

    private static StringBuilder print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]).append(' ');
            }
            sb.append('\n');
        }

        return sb;
    }

    private static void fill(int x, int y, int num, int pos) {
        board[y][x] = num;

        if (num >= N * N) {
            return;
        }

        int nx = x + DX[pos];
        int ny = y + DY[pos];
        if (isBoundary(nx, ny) && board[ny][nx] == 0) {
            fill(nx, ny, num + 1, pos);
        } else {
            fill(x, y, num, (pos + 1) % DX.length);
        }
    }

    private static boolean isBoundary(int nx, int ny) {
        return (nx >= 0 && ny >= 0 && nx < N && ny < N);
    }
}