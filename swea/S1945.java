import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class S1945 {

    static StringBuilder sb = new StringBuilder();
    static int[] primes = { 11, 7, 5, 3, 2 };

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int N = sc.nextInt();

            Map<Integer, Integer> counts = new HashMap<>();

            for (int prime : primes) {
                int cnt = 0;
                while (N > 0 && N % prime == 0) {
                    N /= prime;
                    cnt++;
                }
                counts.put(prime, counts.getOrDefault(prime, 0) + cnt);
            }

            sb.append("#" + test_case + " ");
            for (int i = primes.length - 1; i >= 0; i--) {
                sb.append(counts.get(primes[i])).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}