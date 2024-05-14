import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class P1260_2 {
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> graph = new ArrayList();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList());
        }

        while (M-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append('\n');

        visited = new boolean[N + 1];
        bfs(V);
        sb.append('\n');

        System.out.print(sb);

    }

    private static void dfs(int now) {
        visited[now] = true;
        sb.append(now).append(' ');
        for (int next : graph.get(now)) {
            if (!visited[next]) {
                dfs(next);
            }
        }

    }

    private static void bfs(int now) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(now);
        visited[now] = true;

        while (!q.isEmpty()) {
            now = q.poll();
            sb.append(now).append(' ');

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }

}