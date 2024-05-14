
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class S2806 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int cnt;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            N = sc.nextInt();

            boolean[][] isPlaced = new boolean[N][N];
            cnt = 0;

            dfs(isPlaced, 0);

            sb.append(String.format("#%d %d\n", test_case, cnt));
        }

        System.out.println(sb);
    }

    private static void dfs(boolean[][] isPlaced, int y) {
        if (y >= N) {
            cnt++;
            return;
        }

        for (int x = 0; x < N; x++) {
            if (isValid(isPlaced, x, y)) {
                isPlaced[y][x] = true;
                dfs(isPlaced, y + 1);
                isPlaced[y][x] = false;
            }
        }

    }

    static final int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static final int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

    private static boolean isValid(boolean[][] isPlaced, int x, int y) {

        for (int range = 0; range < N; range++) {
            for (int pos = 0; pos < dx.length; pos++) {
                int nx = x + dx[pos] * range;
                int ny = y + dy[pos] * range;

                if (!isBoundry(nx, ny)) {
                    continue;
                }

                if (isPlaced[ny][nx]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isBoundry(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

}