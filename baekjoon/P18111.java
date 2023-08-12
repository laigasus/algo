import java.io.IOException;

public class P18111 {
    private static int N, M, B;
    private static int[][] board;
    private static final int VALID_HIGH = 256;

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();
        B = readInt();

        board = new int[N][M];
        int limitHigh = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = readInt();
                limitHigh = Math.max(limitHigh, board[i][j]);
            }
        }

        limitHigh = Math.min(limitHigh, VALID_HIGH);
        int minCost = Integer.MAX_VALUE, maxHigh = 0;

        for (int high = 0; high <= limitHigh; high++) {
            int cost = calcCost(high);
            if (cost <= minCost) {
                minCost = cost;
                maxHigh = high;
            }
        }

        System.out.println(minCost + " " + maxHigh);
    }

    private static int calcCost(int high) {
        int cost = 0, invenBlocks = B;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int diff = Math.abs(board[i][j] - high);
                switch (Integer.signum(board[i][j] - high)) {
                    case -1:
                        cost += diff;
                        invenBlocks -= diff;
                        break;
                    case 1:
                        cost += (2 * diff);
                        invenBlocks += diff;
                        break;
                }
            }
        }

        if (invenBlocks < 0) {
            return Integer.MAX_VALUE;
        }

        return cost;
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