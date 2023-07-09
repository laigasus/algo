import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class P2312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Map<Integer, Integer> primes = new LinkedHashMap<>();

            for (int i = 2; i <= N; i++) {
                if (N % i == 0) {
                    primes.put(i, primes.getOrDefault(i, 0) + 1);
                    N /= i;
                    i--;
                }
            }

            for (int key : primes.keySet()) {
                sb.append(key).append(' ');
                sb.append(primes.get(key)).append('\n');
            }
        }
        System.out.print(sb);
    }
}