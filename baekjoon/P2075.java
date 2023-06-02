import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(N);

        for (String s : br.readLine().split(" ")) {
            pq.offer(Integer.parseInt(s));
        }

        while (N-- > 1) {
            for (String s : br.readLine().split(" ")) {
                int num = Integer.parseInt(s);
                if (pq.peek() < num) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }

        System.out.println(pq.poll());
    }
}