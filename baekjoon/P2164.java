import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int num = N; num > 0; num--) {
            deque.offerLast(num);
        }

        while (deque.size() > 1) {
            deque.removeLast();
            deque.offerFirst(deque.pollLast());
        }

        System.out.println(deque.peek());
    }
}
