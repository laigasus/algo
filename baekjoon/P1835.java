import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P1835 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> rs = new HashMap<>();

        Deque<Integer> deque = new ArrayDeque<>(
                IntStream.rangeClosed(1, N)
                        .boxed()
                        .collect(Collectors.toList()));

        for (int n = 1; n < N; n++) {
            int repeat = n;
            while (repeat-- > 0) {
                deque.offerLast(deque.poll());
            }
            rs.put(deque.poll(), n);
        }
        rs.put(deque.poll(), N);

        StringBuilder sb = new StringBuilder();
        for (var entry : rs.entrySet()) {
            sb.append(entry.getValue()).append(' ');
        }

        System.out.println(sb);

    }
}
