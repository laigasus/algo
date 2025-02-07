import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class H7726 {

    private static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static final char WALL = '#';
    private static final char GHOST = 'G';
    private static final char PLAYER = 'N';
    private static final char DESTINATION = 'D';

    private static int[][] dp;
    private static char[][] map;
    private static boolean[][] visited;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m];

        List<Point> ghosts = new ArrayList<>();
        Point start = null, end = null;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);

                map[i][j] = c;

                switch (c) {
                    case GHOST:
                        ghosts.add(new Point(i, j));
                        break;

                    case PLAYER:
                        start = new Point(i, j);
                        break;

                    case DESTINATION:
                        end = new Point(i, j);
                        break;

                    default:
                        break;
                }
            }
        }

        BFS(start);

        // 실패 경우
        // 1. 출구 도달 못함
        // 2. 유령이 출구에 도달하기까지의 거리가 주인공 거리보다 짧음

        int ghostCost = calcGhostShortestCost(ghosts, end);
        int playerCost = dp[end.y][end.x];

        if (playerCost == Integer.MAX_VALUE || playerCost >= ghostCost) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    private static int calcGhostShortestCost(List<Point> ghosts, Point end) {
        int min = Integer.MAX_VALUE;

        for (Point ghost : ghosts) {
            int diffY = Math.abs(end.y - ghost.y);
            int diffX = Math.abs(end.x - ghost.x);

            min = Math.min(min, diffY + diffX);
        }

        return min;
    }

    private static void BFS(Point start) {
        final int[] dx = { -1, 0, 1, 0 };
        final int[] dy = { 0, -1, 0, 1 };

        Queue<Point> q = new LinkedList<>();

        q.offer(start);
        visited[start.y][start.x] = true;
        dp[start.y][start.x] = 0;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (map[now.y][now.x] == DESTINATION) {
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                Point next = new Point(dy[i] + now.y, dx[i] + now.x);

                if (!isBoundry(next.y, next.x)) {
                    continue;
                }

                if (visited[next.y][next.x]) {
                    continue;
                }

                if (map[next.y][next.x] != WALL) {
                    q.offer(next);
                    dp[next.y][next.x] = Math.min(dp[next.y][next.x], dp[now.y][now.x] + 1);
                    visited[next.y][next.x] = true;
                }
            }
        }
    }

    private static boolean isBoundry(int y, int x) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
