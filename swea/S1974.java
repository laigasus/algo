
import java.io.FileInputStream;
import java.util.Scanner;

class S1974 {
    static final int SIZE = 9;
    static int[][] board;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/sudoku.txt"));
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            board = new int[SIZE][SIZE];
            init(sc);

            int result = isValidSudoku() ? 1 : 0;
            sb.append(String.format("#%d %d\n", test_case, result));
        }

        System.out.println(sb);
    }

    private static boolean isValidSudoku() {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j] - 1;
                int boxIndex = (i / 3) * 3 + j / 3;

                if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                    return false;
                }

                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }

        return true;
    }

    private static void init(Scanner sc) {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                board[y][x] = sc.nextInt();
            }
        }
    }
}