import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class P18258_2 {

    private static ArrayDeque<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    int X = Integer.parseInt(st.nextToken());
                    push(X);
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
                default:
                    throw new IOException("wrong input");
            }
        }

        System.out.print(sb);
    }

    private static void push(int X) {
        queue.offer(X);
    }

    private static int pop() {
        if (queue.isEmpty()) {
            return -1;
        }

        return queue.poll();
    }

    private static int size() {
        return queue.size();
    }

    private static int empty() {
        return queue.isEmpty() ? 1 : 0;
    }

    private static int front() {
        if (queue.isEmpty()) {
            return -1;
        }

        return queue.peekFirst();
    }

    private static int back() {
        if (queue.isEmpty()) {
            return -1;
        }

        return queue.peekLast();
    }
}
