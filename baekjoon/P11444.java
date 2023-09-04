import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11444 {
    static final int DIVIDER = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long[][] result = pow(new long[][]{{1, 1}, {1, 0}}, n);

        System.out.println(result[0][1]);
    }

    static long[][] pow(long[][] A, long exp) {
        if (exp == 1) {
            return A;
        }

        long[][] ret = pow(A, exp / 2);
        ret = multiply(ret, ret);

        if (exp % 2 == 1) {
            ret = multiply(ret, A);
        }

        return ret;
    }

    static long[][] multiply(long[][] A, long[][] B) {
        long[][] ret = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    ret[i][j] += A[i][k] * B[k][j];
                    ret[i][j] %= DIVIDER;
                }
            }
        }

        return ret;
    }
}
