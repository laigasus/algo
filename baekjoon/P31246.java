import java.io.IOException;
import java.util.Arrays;

public class P31246 {
    public static void main(String[] args) throws IOException {
        final int N = readInt();
        final int K = readInt();

        int[] ad = new int[N];

        for (int i = 0; i < N; i++) {
            int A = readInt();
            int B = readInt();

            ad[i] = Math.min(A - B, 0);
        }

        Arrays.sort(ad);

        System.out.println(Math.abs(ad[N - K]));
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
