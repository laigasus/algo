import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P11066 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());

            List<Integer> list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed()
                    .collect(Collectors.toList());
            Collections.sort(list);

            ArrayDeque<Integer> deque = new ArrayDeque<>(list);
            int max = deque.peekLast();
            while (deque.size() > 1) {
                int a = deque.pollFirst();
                if (a == max) {
                    list = new ArrayList<>(deque);
                    Collections.sort(list);
                    deque = new ArrayDeque<>(list);
                    max = deque.peekLast();
                    continue;
                }
                int b = deque.pollFirst();

                sum += (a + b);
                deque.addLast(a + b);
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}