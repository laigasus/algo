import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class P5430 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            str = str.substring(1, str.length() - 1);

            if (n == 0) {
                deque = new ArrayDeque<>();
            } else {
                deque = new ArrayDeque<>(
                        Arrays.stream(str.split(",")).mapToInt(Integer::parseInt)
                                .boxed().collect(Collectors.toList()));
            }

            String rs = null;
            boolean isReverse = false;
            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    isReverse = !isReverse;
                    continue;
                }

                if (deque.isEmpty()) {
                    rs = "error";
                    break;
                } else {
                    if (isReverse) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (rs != null) {
                sb.append(rs);
            } else {
                printDeque(deque, isReverse);
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void printDeque(Deque<Integer> deque, boolean isReverse) {
        sb.append('[');

        if (deque.size() > 0) {
            if (isReverse) {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            } else {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
        }
        sb.append(']');
    }
}
