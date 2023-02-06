import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger a = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
        BigInteger b = BigInteger.valueOf(Integer.parseInt(st.nextToken()));

        BigInteger gcd = a.gcd(b); // 최대공약수
        BigInteger lcm = a.multiply(b).divide(gcd); // 최소공배수

        System.out.println(gcd);
        System.out.println(lcm);

        br.close();
    }
}
