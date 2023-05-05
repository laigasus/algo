import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260 {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, V;

    public static void main(String[] args) throws IOException {
        init();

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        graph.forEach(list -> Collections.sort(list));
    }

    static void dfs(int V) {
        visited[V] = true;
        sb.append(V + " ");

        for (int node : graph.get(V)) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

    static void bfs(int V) {
        q.offer(V);
        visited[V] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            sb.append(x + " ");

            for (int node : graph.get(x)) {
                if (!visited[node]) {
                    q.offer(node);
                    visited[node] = true;
                }
            }
        }
    }
}