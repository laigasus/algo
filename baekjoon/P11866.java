import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 1;
        int idx = K;
        List<Integer> queue = IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList());

        sb.append("<");
        while (queue.size() > 1) {
            sb.append(queue.get(idx)).append(", ");
            queue.remove(idx);
            idx = (idx + K) % queue.size();
        }
        sb.append(queue.get(0));
        sb.append(">");

        System.out.println(sb);
        br.close();
    }
}
