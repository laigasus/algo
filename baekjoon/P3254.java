import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3254 {
    static char[][] board = new char[6][7];
    static int[] height = new int[7];
    static int T = 0;
    static boolean isEnded = false;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (T++ < 21) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if (!isEnded) {
                Point si = new Point(a, height[a], 'o');
                board[si.y][si.x] = 'S';
                bfs(si.x, si.y, 'S');
                height[a] += 1;
            }

            if (!isEnded) {
                Point ji = new Point(b, height[b], 'o');
                board[ji.y][ji.x] = 'J';
                bfs(ji.x, ji.y, 'J');
                height[b] += 1;
            }
        }
        if (!isEnded) {
            sb.setLength(0);
            sb.append("ss");
        }
        System.out.println(sb);
    }

    private static class Point {
        int x, y;
        char pos;

        Point(int x, int y, char pos) {
            this.x = x;
            this.y = y;
            this.pos = pos;
        }
    }

    static void bfs(int x, int y, char c) {
        Queue<Point> q = new LinkedList<>();
        boolean visited[][] = new boolean[6][7];

        int vertical = 1, horizontal = 1, diagonalL = 1, diagonalR = 1;
        int dx[];
        int dy[];

        q.offer(new Point(x, y, 'o'));

        loop: while (!q.isEmpty()) {
            Point now = q.poll();
            visited[now.y][now.x] = true;
            if (vertical >= 4 || horizontal >= 4 || diagonalL >= 4 || diagonalR >= 4) {
                sb.append(c == 'S' ? "sk " : "ji ").append(T);
                q.clear();
                isEnded = true;
                break loop;
            }

            switch (now.pos) {
                case 'l':
                    // 0,4
                    dx = new int[] { -1, 1 };
                    dy = new int[] { -1, 1 };
                    break;
                case 'r':
                    // 2,6
                    dx = new int[] { 1, -1 };
                    dy = new int[] { -1, 1 };
                    break;
                case 'v':
                    // 1,5
                    dx = new int[] { 0, 0 };
                    dy = new int[] { -1, 1 };
                    break;
                case 'h':
                    // 3,7
                    dx = new int[] { 1, -1 };
                    dy = new int[] { 0, 0 };
                    break;
                default:
                    dx = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };
                    dy = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
            }

            for (int idx = 0; idx < dx.length; idx++) {
                int nx = now.x + dx[idx];
                int ny = now.y + dy[idx];

                if (nx < 0 || ny < 0 || nx >= 7 || ny >= 6) {
                    continue;
                }

                if (now.pos == 'o' && !visited[ny][nx] && board[ny][nx] == c) {
                    char newPos = 'o';
                    switch (idx) {
                        case 0:
                        case 4:
                            diagonalL++;
                            newPos = 'l';
                            break;
                        case 2:
                        case 6:
                            diagonalR++;
                            newPos = 'r';
                            break;
                        case 1:
                        case 5:
                            vertical++;
                            newPos = 'v';
                            break;
                        case 3:
                        case 7:
                            horizontal++;
                            newPos = 'h';
                            break;
                    }
                    q.offer(new Point(nx, ny, newPos));
                }
                if (now.pos != 'o' && !visited[ny][nx] && board[ny][nx] == c) {
                    switch (now.pos) {
                        case 'l':
                            diagonalL++;
                            break;
                        case 'r':
                            diagonalR++;
                            break;
                        case 'v':
                            vertical++;
                            break;
                        case 'h':
                            horizontal++;
                            break;
                    }
                    q.offer(new Point(nx, ny, now.pos));
                }
            }
        }
    }
}