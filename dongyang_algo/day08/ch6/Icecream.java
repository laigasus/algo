package day08.ch6;

public class Icecream {
    static int[][] graph = { { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } };
    final static int N = graph.length;
    final static int M = graph[0].length;

    public static boolean dfs(int x, int y) {
        if (x >= 0 && y >= 0 && x < M && y < N && graph[y][x] == 0) {
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
                if (dfs(j, i)) {
                    result++;
                }
            }
        }
        System.out.println("총 개수> " + result);
    }
}
