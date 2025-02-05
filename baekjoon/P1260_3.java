import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class P1260_3 {

    private static List<List<Node>> graph = new ArrayList<>();

    private static class Node {
        int v;

        public Node(int v) {
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            graph.get(now).add(new Node(next));
            graph.get(next).add(new Node(now));

        }

        graph.forEach(nodes -> Collections.sort(nodes, (n1, n2) -> n1.v - n2.v));

        System.out.println(DFS(new Node(V), N));
        System.out.println(BFS(new Node(V), N));

    }

    private static String DFS(Node start, final int N) {
        StringJoiner sj = new StringJoiner(" ");
        boolean[] visited = new boolean[N + 1];
        Stack<Node> st = new Stack<>();

        st.push(start);
        visited[start.v] = true;
        sj.add(Integer.toString(start.v));

        while (!st.isEmpty()) {
            Node now = st.peek();
            boolean isDived = false;

            for (Node next : graph.get(now.v)) {
                if (!visited[next.v]) {
                    visited[next.v] = true;
                    st.push(next);
                    sj.add(Integer.toString(next.v));
                    isDived = true;

                    break;
                }
            }

            if (!isDived) {
                st.pop();
            }
        }

        return sj.toString();
    }

    private static String BFS(Node start, final int N) {
        StringJoiner sj = new StringJoiner(" ");
        boolean[] visited = new boolean[N + 1];
        Queue<Node> q = new LinkedList<>();

        q.offer(start);
        visited[start.v] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            sj.add(Integer.toString(now.v));

            for (Node next : graph.get(now.v)) {
                if (!visited[next.v]) {
                    visited[next.v] = true;
                    q.offer(next);
                }
            }
        }

        return sj.toString();
    }

}
