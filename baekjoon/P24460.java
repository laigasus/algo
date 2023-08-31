import java.io.IOException;
import java.util.Arrays;

public class P24460 {
    static int[][] board;
    static final int MIN_SIZE = 4, MIN_N = 2;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = readInt();
            }
        }

        System.out.println(calc(N, 0, 0));
    }

    private static int calc(int N, int y, int x) {
        if (N < MIN_N) {
            return board[y][x];
        }

        N /= 2;
        int[] rs = {
                calc(N, y, x),
                calc(N, y + N, x),
                calc(N, y, x + N),
                calc(N, y + N, x + N)
        };

        Arrays.sort(rs);
        return rs[1];
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