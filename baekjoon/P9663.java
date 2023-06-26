import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9663 {
    static int N;
    static int[] col;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N];

        nQueen(0);
        System.out.println(result);
    }

    public static void nQueen(int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            col[row] = i;
            if (isPossible(row)) {
                nQueen(row + 1);
            }
        }
    }

    public static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (col[i] == col[row]) {
                return false;
            } else if (Math.abs(row - i) == Math.abs(col[row] - col[i])) {
                return false;
            }
        }
        return true;
    }
}