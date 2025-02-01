import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P2749 {
    private static final long MOD = 1_000_000;
    private static final long PISANO_PERIOD = 1_500_000;
    // 피사노 주기 활용. 주기가 M=10^k(k>2) 일때, 항상 15*10^(k-1) 임

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());

        // n을 피사노 주기로 나눈 나머지를 계산
        long remainder = n.mod(BigInteger.valueOf(PISANO_PERIOD)).longValue();

        long result = fibonacci(remainder);

        System.out.println(result);
    }

    private static long fibonacci(long n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        long a = 0, b = 1, c = 0;
        for (long i = 2; i <= n; i++) {
            c = (a + b) % MOD;
            a = b;
            b = c;
        }
        return c;
    }
}