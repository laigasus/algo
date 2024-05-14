import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class P2644 {
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int N, M;
    static int len = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int A = sc.nextInt();
        int B = sc.nextInt();

        M = sc.nextInt();

        while (M-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N + 1];
        dfs(A, B, 0);

        System.out.println(len > 0 ? len : -1);
    }

    private static void dfs(int now, int end, int depth) {
        visited[now] = true;
        if (now == end) {
            len = depth;
            return;
        }

        for (int next : graph.get(now)) {
            if (!visited[next]) {
                dfs(next, end, depth + 1);
            }
        }
    }

}