import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            long n = Long.parseLong(br.readLine());

            while (!isPrimeNumber(n)) {
                n++;
            }
            sb.append(n).append("\n");
        }

        System.out.print(sb);
    }

    static boolean isPrimeNumber(long n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(n); ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
