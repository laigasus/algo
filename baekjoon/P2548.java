import java.io.IOException;
import java.util.Arrays;

public class P2548 {
    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = readInt();
        }

        Arrays.sort(arr);

        System.out.println(arr[N / 2 - (N % 2 == 0 ? 1 : 0)]);
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