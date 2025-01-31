import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P11286_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return Integer.compare(a, b);
            } else {
                return Integer.compare(Math.abs(a), Math.abs(b));
            }
        });

        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (isZero(num)) {
                sb.append((pq.isEmpty() ? 0 : pq.poll())).append('\n');
            } else {
                pq.offer(num);
            }
        }

        System.out.print(sb);
    }

    private static boolean isZero(int num) {
        return num == 0;
    }
}
