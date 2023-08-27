import java.io.IOException;
import java.util.Arrays;

public class P2110 {
    static int N, C;
    static int[] homes;

    public static void main(String[] args) throws IOException {
        N = readInt();
        C = readInt();

        homes = new int[N];

        for (int i = 0; i < N; i++) {
            homes[i] = readInt();
        }

        Arrays.sort(homes);
        int lowDist = 1, highDist = homes[N - 1] - homes[0] + 1;

        System.out.println(binarySearch(lowDist, highDist));
    }

    static int binarySearch(int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;

            int lastInstalledLocation = homes[0], cnt = 1;
            for (int i = 1; i < N; i++) {
                if (homes[i] - lastInstalledLocation >= mid) {
                    lastInstalledLocation = homes[i];
                    cnt++;
                }
            }

            if (cnt < C) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low - 1;
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