import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P10845 {
    static final Deque<Integer> queue = new ArrayDeque<>();
    static final int INF = -2;

    public static void main(String[] args) throws IOException {
        final StringBuilder sb = new StringBuilder();
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int rs = task(br.readLine());
            if (rs != INF) {
                sb.append(rs).append('\n');
            }
        }

        System.out.print(sb);
    }

    static int task(String str) {
        final int INVALID = -1, EMPTY = 1, NOT_EMPTY = 0;
        String[] params = str.split(" ");

        switch (params[0]) {
            case "pop":
                return queue.isEmpty() ? INVALID : queue.poll();

            case "size":
                return queue.size();

            case "empty":
                return queue.isEmpty() ? EMPTY : NOT_EMPTY;

            case "front":
                return queue.isEmpty() ? INVALID : queue.peekFirst();

            case "back":
                return queue.isEmpty() ? INVALID : queue.peekLast();

            case "push":
                queue.offer(Integer.parseInt(params[1]));

            default:
                return INF;
        }
    }
}