import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int[] original = new int[N];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            original[i] = Integer.parseInt(st.nextToken());
        }
        int[] sorted = original.clone();
        Arrays.sort(sorted);

        for (int i = 0, rank = 0; i < sorted.length; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], rank);
                rank++;
            }
        }

        for (int key : original) {
            sb.append(map.get(key)).append(" ");
        }

        System.out.println(sb);
    }
}
