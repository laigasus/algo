import java.io.IOException;
import java.util.Arrays;

public class P11004 {
    public static void main(String[] args) throws IOException {
        final int N = readInt();
        int[] A = new int[N];

        final int K = readInt();

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        Arrays.sort(A);

        System.out.println(A[K - 1]);
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
