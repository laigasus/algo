import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P14425_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        while (N-- > 0) {
            set.add(br.readLine());
        }

        int result = 0;
        while (M-- > 0) {
            if (set.contains(br.readLine())) {
                result++;
            }
        }

        System.out.println(result);

    }
}
