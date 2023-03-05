import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>(IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList()));
        List<Integer> list = new ArrayList<>(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList()));

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            int num = list.get(i);

            while (num != deque.peekFirst()) {
                int idx = new ArrayList<>(deque).indexOf(num);
                int midIdx = deque.size() / 2;
                if (idx <= midIdx) {
                    // 앞을 빼서 뒤에 넣음
                    deque.offerLast(deque.pollFirst());
                } else {
                    // 뒤를 빼서 앞에 넣음
                    deque.offerFirst(deque.pollLast());
                }
                cnt++;

            }
            deque.pollFirst();
        }

        System.out.println(cnt);
    }
}
