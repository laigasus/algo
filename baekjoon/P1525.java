import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P1525 {
    static final String GRAPH_END = "123456780";
    static final char ZERO = '0', TMP = 'T';
    static final int BD_SIZE = 3;

    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String graph = "";
        for (int i = 0; i < BD_SIZE; i++) {
            for (int j = 0; j < BD_SIZE; j++) {
                graph += readInt();
            }
        }

        map.put(graph, 0);
        System.out.println(bfs(graph));
    }

    static int bfs(String start) {
        final int[] dx = { -1, 1, 0, 0 };
        final int[] dy = { 0, 0, -1, 1 };

        Queue<String> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            String now = q.poll();
            int zeroIdx = now.indexOf(ZERO);
            int x = zeroIdx % BD_SIZE;
            int y = zeroIdx / BD_SIZE;

            if (now.equals(GRAPH_END)) {
                return map.get(now);
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= BD_SIZE || ny >= BD_SIZE) {
                    continue;
                }

                int idx = ny * BD_SIZE + nx;
                char dirNum = now.charAt(idx);

                // swap
                String next = now.replace(dirNum, TMP)
                        .replace(ZERO, dirNum)
                        .replace(TMP, ZERO);

                if (map.containsKey(next)) {
                    continue;
                }

                q.add(next);
                map.put(next, map.get(now) + 1);
            }
        }
        return -1;
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