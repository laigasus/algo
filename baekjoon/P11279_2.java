import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P11279_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (isNaturalNumber(num)) {
                pq.offer(num);
            } else {
                sb.append((pq.isEmpty() ? 0 : pq.poll())).append('\n');
            }
        }

        System.out.print(sb);
    }

    private static boolean isNaturalNumber(int num) {
        return num > 0;
    }
}
