import java.util.Arrays;
import java.util.Map;

public class S172928 {
    static class Solution {
        static class Point {
            int y, x;

            public Point(int y, int x) {
                this.y = y;
                this.x = x;
            }
        }

        public static int[] solution(final String[] park, final String[] routes) {
            final int parkWidth = park[0].length();
            final int parkHeight = park.length;

            int[][] board = new int[parkHeight][parkWidth];

            Point now = new Point(0, 0);
            for (int row = 0; row < parkHeight; row++) {
                for (int col = 0; col < parkWidth; col++) {
                    switch (park[row].charAt(col)) {
                        case 'S' -> {
                            now.y = row;
                            now.x = col;
                        }
                        case 'X' -> {
                            board[row][col] = 1;
                        }
                    }
                }
            }

            Map<String, int[]> move = Map.of(
                    "E", new int[] { 1, 0 },
                    "W", new int[] { -1, 0 },
                    "N", new int[] { 0, -1 },
                    "S", new int[] { 0, 1 });

            loop: for (String route : routes) {
                String[] cmd = route.split(" ");
                int[] dir = move.get(cmd[0]);
                int repeat = Integer.parseInt(cmd[1]);

                int ny = now.y;
                int nx = now.x;
                while (repeat-- > 0) {
                    ny += dir[1];
                    nx += dir[0];

                    if (nx < 0 || ny < 0 || nx >= parkWidth || ny >= parkHeight) {
                        continue loop;
                    }

                    if (board[ny][nx] == 1) {
                        continue loop;
                    }
                }
                now.y = ny;
                now.x = nx;
            }

            return new int[] { now.y, now.x };
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.solution(
                new String[] { "SOO", "OOO", "OOO" },
                new String[] { "E 2", "S 2", "W 1" })));

        System.out.println(Arrays.toString(Solution.solution(
                new String[] { "SOO", "OXX", "OOO" },
                new String[] { "E 2", "S 2", "W 1" })));

        System.out.println(Arrays.toString(Solution.solution(
                new String[] { "OSO", "OOO", "OXO", "OOO" },
                new String[] { "E 2", "S 3", "W 1" })));
    }
}