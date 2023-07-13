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

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }
}