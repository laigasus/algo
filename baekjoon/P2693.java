import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P2693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        List<Integer>[] list = new List[T];

        for (int i = 0; i < T; i++) {
            list[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).boxed()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
        }

        for (int i = 0; i < list.length; i++) {
            sb.append(list[i].get(2)).append('\n');
        }

        System.out.print(sb);
    }
}