import java.io.IOException;

public class P2343_1 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();

        int[] disks = new int[N];

        int left = 0, right = 0;
        for (int i = 0; i < N; i++) {
            disks[i] = readInt();
            right += disks[i];
            left = Math.max(left, disks[i]);
        }

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            int cnt = 1, sum = 0;
            for (var disk : disks) {
                sum += disk;

                if (sum > mid) {
                    cnt++;
                    sum = disk;
                }
            }
            if (cnt > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
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
