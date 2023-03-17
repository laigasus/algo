import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(LCM(A, B));
    }

    static long LCM(int A, int B) {
        // 최소공배수= A*B/최대공약수
        BigInteger gcd = BigInteger.valueOf(A).gcd(BigInteger.valueOf(B));
        return BigInteger.valueOf(A).multiply(BigInteger.valueOf(B)).divide(gcd).longValue();
    }
}
