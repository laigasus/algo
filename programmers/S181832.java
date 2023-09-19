import java.util.Arrays;

public class S181832 {
    static class Solution {
        class Point {
            int r, c;

            public Point(int r, int c) {
                this.r = r;
                this.c = c;
            }
        }

        static final int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        public int[][] solution(int N) {
            int[][] answer = new int[N][N];
            Point point = new Point(0, 0);
            int num = 1, range = N * N, d = 0;

            answer[0][0] = num;
            while (num < range) {
                int nr = point.r + dir[d][0];
                int nc = point.c + dir[d][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || answer[nr][nc] != 0) {
                    d = (d + 1) % 4;
                } else {
                    point.r = nr;
                    point.c = nc;
                    answer[point.r][point.c] = ++num;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        for (var arr : T.solution(4)) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
