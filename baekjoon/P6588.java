import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P6588 {
    static final int LIMIT = 1_000_000;
    static boolean[] isPrime = new boolean[LIMIT + 1];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        eratosthenes();

        int num;
        while ((num = Integer.parseInt(br.readLine())) != 0) {
            chkNPrint(num);
        }

        if (sb.length() > 0) {
            System.out.print(sb);
        } else {
            System.out.println("Goldbach's conjecture is wrong.");
            sb.setLength(0);
        }
    }

    static void eratosthenes() {
        isPrime[2] = true;
        for (int i = 3; i <= LIMIT; i += 2) {
            isPrime[i] = true;
        }

        for (int i = 3; i <= LIMIT; i += 2) {
            if (isPrime[i]) {
                for (int j = i * 2; j < LIMIT; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    static void chkNPrint(int n) {
        for (int i = 3; i < n / 2 + 1; i += 2) {
            if (isPrime[i] & isPrime[n - i]) {
                sb.append(n).append(" = ");
                sb.append(i).append(" + ");
                sb.append(n - i).append('\n');
                return;
            }
        }
    }
}