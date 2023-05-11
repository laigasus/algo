import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P24479 {
    static int N, M, R;
    static List<List<Integer>> graph;
    static int[] check;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int depth = 1;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        init();
        dfs(R);

        for (int i = 1; i < check.length; i++) {
            sb.append(check[i]).append('\n');
        }
        System.out.print(sb);
    }

    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());// 정점
        M = Integer.parseInt(st.nextToken());// 간선
        R = Integer.parseInt(st.nextToken());// 시작점

        // 그래프 생성
        graph = new ArrayList<>();
        check = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 값 삽입
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 그래프 정렬
        graph.forEach(list -> Collections.sort(list));
    }

    static void dfs(int R) {
        check[R] = depth++;

        for (int node : graph.get(R)) {
            if (check[node] == 0) {
                dfs(node);
            }
        }
    }
}
