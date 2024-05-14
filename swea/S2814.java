import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class S2814 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();

            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            while (M-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int max = 0;

            for (int node = 1; node <= N; node++) {
                boolean[] visited = new boolean[N + 1];
                visited[node] = true;
                max = Math.max(max, dfs(node, 1, visited));
            }

            sb.append(String.format("#%d %d\n", test_case, max));
        }

        System.out.println(sb);
    }

    private static int dfs(int start, int depth, boolean[] visited) {
        int maxDepth = depth;

        for (int next : graph.get(start)) {
            if (!visited[next]) {
                visited[next] = true;
                maxDepth = Math.max(maxDepth, dfs(next, depth + 1, visited));
                visited[next] = false;
            }
        }

        return maxDepth;
    }
}