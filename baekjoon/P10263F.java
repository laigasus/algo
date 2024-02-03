import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P10263F {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        int result = 0;

        while (!list.isEmpty()) {
            int cutV = list.size();
            int cutH = list.get(list.size() - 1);

            if (cutV < cutH) {
                list.remove(list.size() - 1);
            } else {
                list.replaceAll(num -> num - 1);
                list.removeIf(num -> num == 0);
            }

            result++;
        }

        System.out.println(result);
    }
}
