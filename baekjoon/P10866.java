import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P10866 {
    static Deque<Integer> deque;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        deque = new ArrayDeque<>(N);

        for (int i = 0; i < N; i++) {
            task(br.readLine());
        }

        System.out.print(sb);
    }

    static void task(String cmd) {
        int rs = 0;
        st = new StringTokenizer(cmd);

        switch (st.nextToken()) {
            case "push_front":
                deque.offerFirst(Integer.parseInt(st.nextToken()));
                return;

            case "push_back":
                deque.offerLast(Integer.parseInt(st.nextToken()));
                return;

            case "pop_front":
                try {
                    rs = deque.pollFirst();
                } catch (Exception e) {
                    rs = -1;
                }
                break;

            case "pop_back":
                try {
                    rs = deque.pollLast();
                } catch (Exception e) {
                    rs = -1;
                }
                break;

            case "size":
                rs = deque.size();
                break;

            case "empty":
                rs = deque.isEmpty() ? 1 : 0;
                break;

            case "front":
                try {
                    rs = deque.peekFirst();
                } catch (Exception e) {
                    rs = -1;
                }
                break;

            case "back":
                try {
                    rs = deque.peekLast();
                } catch (Exception e) {
                    rs = -1;
                }
                break;
        }
        sb.append(rs).append("\n");
    }
}
