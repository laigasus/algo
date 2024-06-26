import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4948 {
    public static int[] prime = new int[246913];
    public static int[] cntPrime = new int[246913];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        initPrime();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            } else {
                sb.append(cntPrime[2 * n] - cntPrime[n]).append("\n");
            }
        }
        br.close();
        System.out.print(sb);
    }

    static void initPrime() {
        int cnt = 0;
        prime[0] = 1;
        prime[1] = 1;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i] == 0) {
                for (int j = 2; i * j < prime.length; j++) {
                    prime[i * j] = 1;
                }
            }
        }

        for (int i = 0; i < prime.length; i++) {
            if (prime[i] == 0) {
                cnt++;
            }
            cntPrime[i] = cnt;
        }
    }
}
