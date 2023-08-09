import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class P18110 {
    public static void main(String[] args) throws IOException {
        final double TRIMMED_MEAN = 0.3;
        int n = readInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
        }

        Arrays.sort(arr);

        int cut = (int) Math.round(n * TRIMMED_MEAN / 2.0);
        int[] subArr = Arrays.copyOfRange(arr, cut, arr.length - cut);

        int sum = IntStream.of(subArr).sum();
        long avg = Math.round(sum / (subArr.length * 1.0));

        System.out.println(avg);
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