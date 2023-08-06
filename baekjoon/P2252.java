import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P2252 {
    static int N, M;
    static List<List<Integer>> graph;
    static int[] indegrees;
    static final StringJoiner sj = new StringJoiner(" ");
    static final int START_NODE_NUM = 1;

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();

        graph = Stream.generate(ArrayList<Integer>::new)
                .limit(N + 1)
                .collect(Collectors.toList());

        indegrees = new int[N + 1];

        while (M-- > 0) {
            int A = readInt();
            int B = readInt();
            graph.get(A).add(B);
            indegrees[B]++;
        }

        bfs();

        System.out.println(sj);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = START_NODE_NUM; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            sj.add(Integer.toString(now));

            for (int next : graph.get(now)) {
                indegrees[next]--;

                if (indegrees[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }

    private static int readInt() throws IOException {
        int rs = 0;
        boolean isNegative = false;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        if (c == '-') {
            isNegative = true;
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return isNegative ? -rs : rs;
    }
}