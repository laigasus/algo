import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1735 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int numeratorA = Integer.parseInt(st.nextToken());
        int denominatorA = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int numeratorB = Integer.parseInt(st.nextToken());
        int denominatorB = Integer.parseInt(st.nextToken());

        long numerator = numeratorA * denominatorB + numeratorB * denominatorA;
        long denominator = denominatorA * denominatorB;
        long gcd = GCD(numerator, denominator);

        sb.append(numerator / gcd);
        sb.append(' ');
        sb.append(denominator / gcd);
        System.out.println(sb);
    }

    static long GCD(long A, long B) {
        return BigInteger.valueOf(A).gcd(BigInteger.valueOf(B)).longValue();
    }
}