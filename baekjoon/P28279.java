import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class P28279 {
    public static void main(String[] args) throws IOException {
        final int NONE = -1;
        int N = readInt();
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            switch (readInt()) {
                case 1:
                    deque.addFirst(readInt());
                    break;
                case 2:
                    deque.addLast(readInt());
                    break;
                case 3:
                    sb.append(deque.isEmpty() ? NONE : deque.pollFirst()).append('\n');
                    break;
                case 4:
                    sb.append(deque.isEmpty() ? NONE : deque.pollLast()).append('\n');
                    break;
                case 5:
                    sb.append(deque.size()).append('\n');
                    break;
                case 6:
                    sb.append(deque.isEmpty() ? 1 : 0).append('\n');
                    break;
                case 7:
                    sb.append(deque.isEmpty() ? NONE : deque.peekFirst()).append('\n');
                    break;
                case 8:
                    sb.append(deque.isEmpty() ? NONE : deque.peekLast()).append('\n');
                    break;
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