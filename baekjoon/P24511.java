import java.io.IOException;
import java.util.ArrayDeque;

public class P24511 {
    public static void main(String[] args) throws IOException {
        int N = readInt();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] isStack = new boolean[N];

        for (int i = 0; i < N; i++) {
            isStack[i] = readInt() == 1;
        }

        for (int i = 0; i < N; i++) {
            int value = readInt();
            if (!isStack[i]) {
                queue.offerLast(value);
            }
        }

        int M = readInt();

        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            int value = readInt();
            queue.offerFirst(value);
            sb.append(queue.pollLast()).append(' ');
        }

        System.out.println(sb);
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
