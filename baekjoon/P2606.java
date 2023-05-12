import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P2606 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int cnt = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
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

        dfs(1);

        System.out.println(cnt < 0 ? 0 : cnt);
    }

    static void dfs(int start) {
        visited[start] = true;
        cnt++;

        for (int node : graph.get(start)) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }
}