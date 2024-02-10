import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P14729F {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Double, Integer> scores = new HashMap<>();
        PriorityQueue<Double> queue = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            Double score = Double.parseDouble(br.readLine());
            scores.put(score, scores.getOrDefault(score, 0) + 1);
            if (scores.get(score) == 1) {
                queue.add(score);
            }
        }

        StringBuilder sb = new StringBuilder();
        int top = 7;

        while (top > 0 && !queue.isEmpty()) {
            Double score = queue.poll();
            int count = scores.get(score);
            for (int i = 0; i < count && top > 0; i++) {
                sb.append(String.format("%.3f\n", score));
                top--;
            }
        }

        System.out.print(sb);
    }
}
