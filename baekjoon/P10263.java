import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class P10263 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int result = 0;

        int cutPos = 0;
        for (int i = 0; i < n; i++) {
            int diff = arr[i] - cutPos;

            if (diff <= 0) {
                continue;
            }

            result++;

            if (diff < arr[n - 1]) {
                cutPos++;
            }
        }

        System.out.println(result);
    }
}
