import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int repeat = Integer.parseInt(br.readLine());
        List<String> list;

        for (int i = 0; i < repeat; i++) {
            int sum = 0;
            list = new ArrayList<>(Arrays.stream(br.readLine().split("X")).collect(Collectors.toList()));
            for (int j = 0; j < list.size(); j++) {
                int len = list.get(j).length();
                sum += IntStream.rangeClosed(1, len).boxed().mapToInt(e -> e).sum();
            }
            sb.append(sum + "\n");

        }
        br.close();
        System.out.print(sb);
    }
}
