import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class P4195 {
    static final int MAX = 100_000 * 2;
    static int[] parent;
    static int[] friends;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {

        int T = readInt();

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            map = new HashMap<>();
            parent = IntStream.rangeClosed(0, MAX).toArray();
            friends = IntStream.generate(() -> 1).limit(MAX + 1).toArray();

            int num = 1;
            int F = readInt();
            while (F-- > 0) {
                String f1 = read(), f2 = read();

                if (!map.containsKey(f1)) {
                    map.put(f1, num++);
                }

                if (!map.containsKey(f2)) {
                    map.put(f2, num++);
                }

                sb.append(union(map.get(f1), map.get(f2))).append('\n');
            }

        }

        System.out.print(sb);
    }

    private static int union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
            friends[a] += friends[b];
        }

        return friends[a];
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

    private static String read() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        while (c > ' ') {
            sb.append((char) c);
            c = System.in.read();
        }
        return sb.toString();
    }

}
