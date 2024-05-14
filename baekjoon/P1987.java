import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P1987 {
    static char[][] board;
    static boolean[] visited;
    static int max = 0;
    static int R, C;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for (int y = 0; y < R; y++) {
            String str = br.readLine();
            for (int x = 0; x < C; x++) {
                board[y][x] = str.charAt(x);
            }
        }

        visited = new boolean[26];
        visited[board[0][0] - 'A'] = true;

        dfs(0, 0, 1);

        System.out.println(max);

    }

    static final int[] dx = { -1, 0, 1, 0 };
    static final int[] dy = { 0, -1, 0, 1 };

    private static void dfs(int y, int x, int depth) {
        for (int i = 0; i < dx.length; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (!isInside(ny, nx)) {
                continue;
            }

            int idx = board[ny][nx] - 'A';

            if (!visited[idx]) {
                visited[idx] = true;
                dfs(ny, nx, depth + 1);
                visited[idx] = false;
            }
        }

        max = Math.max(max, depth);
    }

    private static boolean isInside(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < R && nx < C;
    }

}