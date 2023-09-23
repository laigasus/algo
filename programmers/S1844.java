import java.util.LinkedList;
import java.util.Queue;

public class S1844 {
    static class Solution {
        static final int[] dy = { -1, 0, 1, 0 };
        static final int[] dx = { 0, 1, 0, -1 };

        static class Point {
            int y, x;

            public Point(int y, int x) {
                this.y = y;
                this.x = x;
            }
        }

        public static int solution(int[][] maps) {
            Queue<Point> q = new LinkedList<>();
            final int ROW_LEN = maps.length;
            final int COL_LEN = maps[0].length;

            int[][] dp = new int[ROW_LEN][COL_LEN];
            dp[0][0] = 1;
            q.offer(new Point(0, 0));

            while (!q.isEmpty()) {
                Point now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = now.y + dy[i];
                    int nx = now.x + dx[i];

                    if (nx < 0 || ny < 0 || nx >= COL_LEN || ny >= ROW_LEN) {
                        continue;
                    }

                    if (maps[ny][nx] == 0) {
                        continue;
                    }

                    if (dp[ny][nx] == 0) {
                        dp[ny][nx] = dp[now.y][now.x] + 1;
                        q.offer(new Point(ny, nx));
                    }
                }
            }

            int rs = dp[ROW_LEN - 1][COL_LEN - 1];
            return rs == 0 ? -1 : rs;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[][] {
                { 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 }
        }));
        System.out.println(Solution.solution(new int[][] {
                { 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1 },
                { 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1 }
        }));
    }
}
