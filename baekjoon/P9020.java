import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9020 {
    static int[] prime = new int[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        initPrime();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = n / 2;; j--) {
                if (prime[j] == 0 && prime[n - j] == 0) {
                    sb.append(j).append(" ").append(n - j).append("\n");
                    break;
                }
            }
        }

        br.close();
        System.out.print(sb);
    }

    static void initPrime() {
        prime[0] = 1;
        prime[1] = 1;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i] == 0) {
                for (int j = 2; i * j < prime.length; j++) {
                    prime[i * j] = 1;
                }
            }
        }
    }
}
