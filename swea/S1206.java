import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class S1206 {
    static final int MAX_HEIGHT = 255;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] board;
    static int heights[];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            init(sc);
            int result = calc();
            sb.append(String.format("#%d %d\n", test_case, result));
        }

        sc.close();

        System.out.println(sb);
    }

    private static int calc() {
        int cnt = 0;

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < heights[y]; x++) {
                if (isValid(x, y)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static boolean isValid(int x, int y) {
        final int SPACE = 2;

        for (int i = -1 * SPACE; i <= SPACE; i++) {
            if (i == 0) {
                continue;
            }
            if (board[y + i][x]) {
                return false;
            }
        }
        return true;
    }

    private static void init(Scanner sc) {
        int towers = sc.nextInt();
        board = new boolean[towers][MAX_HEIGHT + 1];
        heights = new int[towers];

        for (int y = 0; y < towers; y++) {
            int height = sc.nextInt();
            heights[y] = height;

            Arrays.fill(board[y], 0, height, true);
        }
    }

}