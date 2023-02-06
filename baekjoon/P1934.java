import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            BigInteger a = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
            BigInteger b = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
            BigInteger gcd = a.gcd(b); // 최대공약수
            BigInteger lcm = a.multiply(b).divide(gcd); // 최소공배수

            sb.append(lcm).append(("\n"));
        }
        System.out.print(sb);
        br.close();
    }
}
