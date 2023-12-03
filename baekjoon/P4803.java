import java.io.IOException;
import java.util.HashSet;
import java.util.stream.IntStream;

public class P4803 {
    private static int N, M;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int repeat = 1;
        while (true) {
            N = readInt();
            M = readInt();
            if (N == 0 && M == 0) {
                break;
            }

            parent = IntStream.rangeClosed(0, N).toArray();

            while (M-- > 0) {
                int a = readInt();
                int b = readInt();

                union(a, b);
            }

            HashSet<Integer> trees = new HashSet<>();
            for (int node = 1; node <= N; node++) {
                int root = find(node);

                if (root > 0) {
                    trees.add(root);
                }
            }

            sb.append("Case ").append(repeat++).append(": ");
            switch (trees.size()) {
                case 0:
                    sb.append("No trees.");
                    break;
                case 1:
                    sb.append("There is one tree.");
                    break;
                default:
                    sb.append("A forest of ").append(trees.size()).append(" trees.");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (b < a) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        if (a == b) {
            parent[a] = 0;
        } else {
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
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
