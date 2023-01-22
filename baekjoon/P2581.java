import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        br.close();
        List<Integer> primeList = new ArrayList<>(IntStream.rangeClosed(M, N).boxed()
                .filter(i -> BigInteger.valueOf(i).isProbablePrime(10)).collect(Collectors.toList()));

        if (primeList.size() == 0) {
            sb.append("-1");
        } else {
            sb.append(primeList.stream().mapToInt(Integer::intValue).sum()).append("\n");
            sb.append(primeList.stream().mapToInt(Integer::intValue).min().getAsInt()).append("\n");
        }
        System.out.println(sb);
    }
}
