import java.io.IOException;

public class P1654 {
    public static void main(String[] args) throws IOException {
        int K = readInt();
        int N = readInt();

        int[] cables = new int[K];
        long left = 1, right = 0;

        for (int i = 0; i < K; i++) {
            int value = readInt();
            cables[i] = value;
            right = Math.max(right, value);
        }

        long rs = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;

            int cnt = 0;
            for (int cable : cables) {
                cnt += cable / mid;
            }

            if (cnt < N) {
                right = mid - 1;
            } else {
                rs = mid;
                left = mid + 1;
            }
        }

        System.out.println(rs);
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