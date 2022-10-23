package day06;

public class Icecream {
    static int M = 5, N = 4;

    static int[][] graph = { { 0, 0, 1, 1, 0 }, { 0, 0, 0, 1, 1 }, { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };

    public static boolean dfs(int x, int y) {
        if (x <= -1 || x >= M || y <= -1 || y >= N) {
            return false;
        }
        if (graph[y][x] == 0) {
            graph[y][x] = 1;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(j, i))
                    result++;
            }
        }
        System.out.println("result>" + result);
    }
}
