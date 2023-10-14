import java.io.IOException;

public class P11403 {
    static int N;
    static int[][] floyd;

    public static void main(String[] args) throws IOException {
        N = readInt();
        floyd = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                floyd[i][j] = readInt();
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (floyd[i][k] == 1 && floyd[k][j] == 1) {
                        floyd[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                sb.append(floyd[row][col]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
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