import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class P1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int rs = 0;
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            rs += a + b;
            queue.add(a + b);
        }

        System.out.println(rs);
    }
}