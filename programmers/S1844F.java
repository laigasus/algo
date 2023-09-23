import java.util.LinkedList;
import java.util.Queue;

public class S1844F {
    static class Solution {
        static final int[] dy = { -1, 0, 1, 0 };
        static final int[] dx = { 0, 1, 0, -1 };

        static class Point {
            int y, x, cnt;

            public Point(int y, int x, int cnt) {
                this.y = y;
                this.x = x;
                this.cnt = cnt;
            }
        }

        public static int solution(int[][] maps) {
            Queue<Point> q = new LinkedList<>();
            final int ROW_LEN = maps.length;
            final int COL_LEN = maps[0].length;

            boolean[][] visited = new boolean[ROW_LEN][COL_LEN];
            visited[0][0] = true;
            q.offer(new Point(0, 0, 1));

            int min = Integer.MAX_VALUE;
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

                    if (visited[ny][nx]) {
                        continue;
                    }

                    if (ny == ROW_LEN - 1 && nx == COL_LEN - 1) {
                        min = Math.min(min, now.cnt + 1);
                    } else {
                        visited[ny][nx] = true;
                        q.offer(new Point(ny, nx, now.cnt + 1));
                    }
                }
            }

            return min == Integer.MAX_VALUE ? -1 : min;
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
