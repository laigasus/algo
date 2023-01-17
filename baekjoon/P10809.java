import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        List<Integer> alphabet = IntStream.rangeClosed(97, 122).boxed().collect(Collectors.toList());
        for (int n : alphabet) {
            sb.append(S.indexOf((char) n + "") + " ");
        }
        System.out.print(sb);
    }
}
