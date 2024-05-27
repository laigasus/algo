import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class P1976_2 {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));

        N = readInt();
        M = readInt();

        parent = IntStream.rangeClosed(0, N).toArray();

        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= N; b++) {
                boolean isConnected = readInt() == 1;
                if (isConnected) {
                    union(a, b);
                }
            }
        }

        int[] courses = new int[M];
        for (int i = 0; i < M; i++) {
            courses[i] = readInt();
        }

        Arrays.sort(courses);

        boolean result = isValid(courses);

        System.out.println(result ? "YES" : "NO");
    }

    private static boolean isValid(int[] courses) {
        for (int course : courses) {
            if (find(course) != courses[0]) {
                return false;
            }
        }

        return true;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
        } else if (a > b) {
            parent[a] = b;
        }
    }

    private static int find(int x) {
        if (x == parent[x]) {
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