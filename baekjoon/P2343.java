import java.io.IOException;

// 참고 https://today-retrospect.tistory.com/244
public class P2343 {

    static int N, M;
    static int[] disks;
    static final int MAX_LECTURE = 100_000;
    static final int MAX_EACH_TIME = 10_000;
    static final int MAX_LAPSE = MAX_LECTURE * MAX_EACH_TIME;

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();
        disks = new int[N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            disks[i] = readInt();
            max = Math.max(max, disks[i]);
        }
        System.out.println(binarySearch(max, MAX_LAPSE));
    }

    public static int binarySearch(int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = 1;

            int sum = 0;
            for (int disk : disks) {
                sum += disk;
                if (sum > mid) {
                    sum = disk;
                    cnt++;
                }
            }

            if (cnt <= M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
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