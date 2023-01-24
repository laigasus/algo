import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P2566 {
    public static void main(String[] args) throws IOException {
        int row = 9;
        List<Integer> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < row; i++) {
            list.addAll(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).boxed()
                    .collect(Collectors.toList()));
        }
        br.close();

        int max = list.stream().mapToInt(i -> i).max().getAsInt();
        sb.append(max).append("\n");
        int idx = list.indexOf(max);
        sb.append((idx / row) + 1).append(" ").append((idx % row) + 1);
        System.out.println(sb);
    }
}
