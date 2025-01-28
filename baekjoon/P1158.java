import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(yoseputh(N, K));
    }

    private static String yoseputh(int N, int K) {
        StringJoiner sj = new StringJoiner(", ", "<", ">");
        ArrayDeque<Integer> deque = new ArrayDeque<>(numberize(N));
        int cnt = K;
        while (!deque.isEmpty()) {
            int polled = deque.pollFirst();
            if (cnt == 1) {
                cnt = K;
                sj.add(String.valueOf(polled));
            } else {
                cnt--;
                deque.offerLast(polled);
            }
        }

        return sj.toString();
    }

    private static List<Integer> numberize(int N) {
        return IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList());
    }
}
