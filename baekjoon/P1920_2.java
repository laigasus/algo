import java.io.IOException;
import java.util.Arrays;

public class P1920_2 {
    public static void main(String[] args) throws IOException {
        final int N = readInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = readInt();
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        int M = readInt();

        while (M-- > 0) {
            int num = readInt();

            sb.append(binarySearch(arr, num)).append('\n');
        }

        System.out.print(sb);
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (target < arr[mid]) {
                right = mid - 1;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                return 1;
            }
        }

        return 0;
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
