import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P24444 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<List<Integer>> graph;
    static Queue<Integer> queue = new LinkedList<>();
    static StringTokenizer st;
    static int[] rs;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        bfs(N, M, R);

        for (int i = 1; i < rs.length; i++) {
            sb.append(rs[i]).append('\n');
        }
        System.out.print(sb);
    }

    static void init(int V, int E) throws IOException {

        graph = new ArrayList<>();
        rs = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        graph.forEach(list -> Collections.sort(list));
    }

    static void bfs(int V, int E, int R) throws IOException {
        init(V, E);
        queue.offer(R);
        int depth = 1;
        rs[R] = depth;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : graph.get(u)) {
                if (rs[v] == 0) {
                    queue.offer(v);
                    rs[v] = ++depth;
                }
            }
        }
    }
}