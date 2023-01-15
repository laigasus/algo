import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P5597 {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>(IntStream.rangeClosed(1, 30).boxed().collect(Collectors.toList()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 28; i++) {
            int idx = Integer.parseInt(br.readLine());
            list.remove(list.indexOf(idx));
        }
        br.close();
        list.forEach(System.out::println);
    }
}
