import java.io.IOException;

public class P1300_1 {
    public static void main(String[] args) throws IOException {
        int N = readInt();
        int K = readInt();

        int left = 1, right = K;
        int result = 0;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }
            if (cnt < K) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
        System.out.println(result);

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
