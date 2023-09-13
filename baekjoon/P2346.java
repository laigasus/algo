import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class P2346 {
    static Deque<Integer> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = readInt();
            deque.offer(i + 1);
        }

        while (!deque.isEmpty()) {
            int index = deque.pollFirst();
            sb.append(index).append(' ');

            if (deque.isEmpty()) {
                break;
            }

            int step = arr[index - 1];

            if (step > 0) {
                for (int i = 0; i < step - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                step = -step;
                for (int i = 0; i < step; i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
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
