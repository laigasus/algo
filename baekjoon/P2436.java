import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int gcm = Integer.parseInt(st.nextToken());
        int lcm = Integer.parseInt(st.nextToken());

        long n = (long) gcm * lcm;
        int sqrt = (int) Math.sqrt(n);

        int a = 0, b = 0;
        for (int i = gcm; i <= sqrt; i += gcm) {
            if (n % i != 0) {
                continue;
            }
            if (gcd(i, n / i) == gcm) {
                a = i;
                b = (int) (n / i);
            }
        }

        System.out.println(a + " " + b);
    }

    static long gcd(long a, long b) {
        long r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}