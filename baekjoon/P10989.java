import java.io.IOException;

public class P10989 {
    public static void main(String[] args) throws IOException {
        final int max = 10000;
        int N = readInt();

        int[] arr = new int[max + 1];

        while (N-- > 0) {
            arr[readInt()]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int num = 1; num <= max; num++) {
            while (arr[num] > 0) {
                sb.append(num).append('\n');
                arr[num]--;
            }
        }

        System.out.print(sb);
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
