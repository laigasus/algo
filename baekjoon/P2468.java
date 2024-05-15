import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P2468 {
    static int[][] board;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        int low = 0, high = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                board[i][j] = value;

                high = Math.max(high, value);
            }
        }

        int max = 0;
        for (int drown = low; drown <= high; drown++) {
            visited = new boolean[N][N];
            int cnt = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (!visited[y][x] && board[y][x] > drown) {
                        dfs(y, x, drown);
                        cnt++;
                    }
                }
            }

            max = Math.max(max, cnt);

        }

        // 물에 잠기지 않는 안전한 영역이 최대로 몇 개
        System.out.println(max);
    }

    static final int[] dx = { -1, 0, 1, 0 };
    static final int[] dy = { 0, -1, 0, 1 };

    private static void dfs(int y, int x, int drown) {
        visited[y][x] = true;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!isInside(ny, nx)) {
                continue;
            }

            if (board[ny][nx] <= drown) {
                continue;
            }

            if (!visited[ny][nx]) {
                dfs(ny, nx, drown);
            }
        }
    }

    private static boolean isInside(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }

}