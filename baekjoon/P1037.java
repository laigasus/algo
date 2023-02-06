import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class P1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        TreeSet<Integer> set = new TreeSet<>();

        set.addAll(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList()));

        br.close();
        System.out.println(set.first() * set.last());
    }
}
