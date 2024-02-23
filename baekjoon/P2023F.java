import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P2023F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        final int start = (int) Math.pow(10, N - 1);
        final int end = (int) Math.pow(10, N);

        StringBuilder sb = new StringBuilder();
        for (int num = start; num < end; num++) {
            if (isPrime(num)) {
                sb.append(num).append('\n');
            }
        }

        System.out.print(sb);
    }

    private static boolean isPrime(int num) {
        do {
            if (!BigInteger.valueOf(num).isProbablePrime(10)) {
                return false;
            }
        } while ((num /= 10) > 0);

        return true;
    }

}
