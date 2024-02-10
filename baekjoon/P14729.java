import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class P14729 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Double, Integer> scores = new TreeMap<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            Double score = Double.parseDouble(br.readLine());
            scores.put(score, scores.getOrDefault(score, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int top = 7;

        loop: for (var entrySet : scores.entrySet()) {
            for (int i = 0; i < entrySet.getValue(); i++) {
                if (top <= 0) {
                    break loop;
                }

                sb.append(String.format("%.3f\n", entrySet.getKey()));
                top--;
            }
        }

        System.out.print(sb);
    }
}
