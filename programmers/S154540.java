import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class S154540 {

    static class Solution {
        static boolean[][] visited;
        static int width, height;
        static int board[][];

        static final int[] dy = { -1, 0, 1, 0 };
        static final int[] dx = { 0, 1, 0, -1 };

        static int sum = 0;

        private static void DFS(int y, int x) {
            sum += board[y][x];
            visited[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (nx < 0 || ny < 0 || nx >= width || ny >= height) {
                    continue;
                }

                if (visited[ny][nx]) {
                    continue;
                }

                if (board[ny][nx] > 0) {
                    DFS(ny, nx);
                }
            }
        }

        public static Integer[] solution(String[] maps) {
            height = maps.length;
            width = maps[0].length();

            board = new int[height][width];
            visited = new boolean[height][width];

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    char c = maps[i].charAt(j);
                    if (Character.isDigit(c)) {
                        board[i][j] = Integer.parseInt("" + c);
                    }
                }
            }

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (!visited[i][j] && board[i][j] > 0) {
                        DFS(i, j);
                        list.add(sum);
                        sum = 0;
                    }
                }
            }

            Collections.sort(list);

            return list.isEmpty() ? new Integer[] { -1 } : list.toArray(Integer[]::new);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.solution(new String[] { "X591X", "X1X5X", "X231X", "1XXX1" })));
    }
}
