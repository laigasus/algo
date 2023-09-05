import java.io.IOException;
import java.util.Arrays;

public class P14467 {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] arr = new int[11];

        Arrays.fill(arr, -1);

        int rs = 0;

        while (n-- > 0) {
            int a = readInt();
            int b = readInt();

            if (arr[a] != -1 && arr[a] != b) {
                rs++;
            }

            arr[a] = b;
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