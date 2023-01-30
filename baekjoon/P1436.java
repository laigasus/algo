import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        List<String> series = IntStream.rangeClosed(1, 2666799).mapToObj(i -> i + "")
                .filter(s -> s.contains("666"))
                .collect(Collectors.toList());
        System.out.println(series.get(N - 1));
    }
}
