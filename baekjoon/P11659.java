import java.io.IOException;

public class P11659 {
    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt();

        int[] prefixSum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int now = readInt();
            prefixSum[i] = prefixSum[i - 1] + now;
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            int start = readInt() - 1;
            int end = readInt();

            int result = prefixSum[end] - prefixSum[start];
            sb.append(result).append('\n');
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
