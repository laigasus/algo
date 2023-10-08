import java.io.IOException;

public class P17951 {
    static int[] tests;
    static int N, K;

    public static void main(String[] args) throws IOException {
        N = readInt();
        K = readInt();

        tests = new int[N];

        int left = 0;
        int right = 0;

        for (int i = 0; i < N; i++) {
            tests[i] = readInt();
            right += tests[i];
        }

        System.out.println(binarySearch(left, right));
    }

    private static int binarySearch(int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0, cnt = 0;
            for (int i = 0; i < N; i++) {
                sum += tests[i];
                if (sum >= mid) {
                    cnt++;
                    sum = 0;
                }
            }

            if (cnt >= K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
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
