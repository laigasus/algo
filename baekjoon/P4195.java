import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class P4195 {
    static final int MAX = 100_000 * 2;

    static int[] parent, friends;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            map = new HashMap<>();
            parent = IntStream.rangeClosed(0, MAX).toArray();
            friends = IntStream.generate(() -> 1).limit(MAX + 1).toArray();

            int N = Integer.parseInt(br.readLine());

            int num = 1;
            while (N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String f1 = st.nextToken();
                String f2 = st.nextToken();

                num = checkContainsMap(num, f1);
                num = checkContainsMap(num, f2);

                sb.append(union(map.get(f1), map.get(f2))).append('\n');
            }

        }

        System.out.print(sb);

    }

    private static int checkContainsMap(int num, String f) {
        if (!map.containsKey(f)) {
            map.put(f, num++);
        }
        return num;
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

}
