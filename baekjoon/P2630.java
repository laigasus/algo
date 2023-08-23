import java.io.IOException;

public class P2630 {
    final static int WHITE = 0, BLUE = 1;

    static int[][] board;
    static int[] colors = { 0, 0 };

    public static void main(String[] args) throws IOException {
        int N = readInt();
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = readInt();
            }
        }
        check(N, 0, 0);

        System.out.println(colors[WHITE]);
        System.out.println(colors[BLUE]);
    }

    static void check(int size, int x, int y) {
        if (isValid(size, x, y)) {
            colors[board[y][x]]++;

            return;
        }

        size /= 2;

        check(size, x, y);
        check(size, x, y + size);
        check(size, x + size, y);
        check(size, x + size, y + size);
    }

    private static boolean isValid(int size, int x, int y) {
        int startColor = board[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (startColor != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
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