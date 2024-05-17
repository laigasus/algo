import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class S1210 {
    static final int SIZE = 100, NONE = -1;
    static StringBuilder sb = new StringBuilder();
    static int[][] data;
    static int result;
    static List<Integer> ladders;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int test_num = sc.nextInt();
            data = new int[SIZE][SIZE];
            ladders = new ArrayList<>();
            result = NONE;

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    data[i][j] = sc.nextInt();
                }
            }

            for (int x = 0; x < SIZE; x++) {
                if (data[0][x] == 1) {
                    ladders.add(x);
                }
            }

            for (int idx = 0; idx < ladders.size(); idx++) {
                int x = ladders.get(idx);
                dfs(x, 0, x, idx);

                if (result > NONE) {
                    break;
                }
            }

            sb.append(String.format("#%d %d\n", test_num, result));
        }

        sc.close();

        System.out.println(sb);
    }

    static final int[] dx = { -1, 1 };

    private static void dfs(int start, int y, int x, int ladderIdx) {
        if (y >= SIZE) {
            return;
        }

        if (data[y][x] == 2) {
            result = start;
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            if (isInside(y, nx) && data[y][nx] == 1) {
                ladderIdx += dx[i];
                nx = ladders.get(ladderIdx);

                dfs(start, y + 1, nx, ladderIdx);
                return;
            }
        }

        dfs(start, y + 1, x, ladderIdx);
    }

    private static boolean isInside(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < SIZE && nx < SIZE;
    }

}