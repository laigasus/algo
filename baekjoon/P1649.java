import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class P1649 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> list = IntStream.rangeClosed(1, N).boxed().toList();

    }

    static void sibal(List<Integer> list, int a, int N) {

        if (a > 1) {
            sb.append("\n");
            sibal(list, a, N);
            for (int i = 1; i <= N; i++) {
                sb.append(i).append(" ");
            }
        } else {
            for (int i = 1; i <= N; i++) {

            }
        }

    }
}
