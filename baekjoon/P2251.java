import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2251 {
    private static final int MAX = 200;
    private static int A, B, C;
    private static boolean[][] visited;
    private static List<Integer> cases = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        A = readInt();
        B = readInt();
        C = readInt();

        visited = new boolean[MAX + 1][MAX + 1];

        calc(0, 0, C);

        Collections.sort(cases);

        StringBuilder sb = new StringBuilder();
        cases.forEach(e -> sb.append(e).append(' '));

        System.out.println(sb);
    }

    private static void calc(int a, int b, int c) {
        if (visited[a][b]) {
            return;
        }

        visited[a][b] = true;

        if (a == 0) {
            cases.add(c);
        }

        moveWaterA2B(a, b, c);
        moveWaterA2C(a, b, c);
        moveWaterB2A(a, b, c);
        moveWaterB2C(a, b, c);
        moveWaterC2A(a, b, c);
        moveWaterC2B(a, b, c);
    }

    private static void moveWaterC2B(int a, int b, int c) {
        if (c != 0 && b != B) {
            int move = Math.min(c, B - b);
            calc(a, b + move, c - move);
        }
    }

    private static void moveWaterC2A(int a, int b, int c) {
        if (c != 0 && a != A) {
            int move = Math.min(c, A - a);
            calc(a + move, b, c - move);
        }
    }

    private static void moveWaterB2C(int a, int b, int c) {
        if (b != 0 && c != C) {
            int move = Math.min(b, C - c);
            calc(a, b - move, c + move);
        }
    }

    private static void moveWaterB2A(int a, int b, int c) {
        if (b != 0 && a != A) {
            int move = Math.min(b, A - a);
            calc(a + move, b - move, c);
        }
    }

    private static void moveWaterA2C(int a, int b, int c) {
        if (a != 0 && c != C) {
            int move = Math.min(a, C - c);
            calc(a - move, b, c + move);
        }
    }

    private static void moveWaterA2B(int a, int b, int c) {
        if (a != 0 && b != B) {
            int move = Math.min(a, B - b);
            calc(a - move, b + move, c);
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
