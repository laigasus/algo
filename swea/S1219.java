import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class S1219 {
    static final int SZIE = 100, START = 0, END = 99;
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> graph;
    static boolean[] visited;
    static boolean isReached;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt();

            int M = sc.nextInt();

            graph = new ArrayList<>();
            for (int i = 0; i <= SZIE; i++) {
                graph.add(new ArrayList<>());
            }

            visited = new boolean[SZIE + 1];
            isReached = false;

            while (M-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                graph.get(a).add(b);
            }

            dfs(START);

            sb.append(String.format("#%d %d\n", test_case, isReached ? 1 : 0));
        }

        System.out.println(sb);
    }

    private static void dfs(int now) {
        if (isReached) {
            return;
        }

        if (now == END) {
            isReached = true;
            return;
        }

        visited[now] = true;

        for (int next : graph.get(now)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}