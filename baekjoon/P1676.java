import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P1676 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(zeroSize(n));
    }

    static int zeroSize(int n) {
        StringBuilder sb = new StringBuilder(factorial(n));
        String str = new String(sb.reverse());
        str = str.replaceFirst("[1-9]", "*");
        str = str.substring(0, str.indexOf("*"));
        return str.length();
    }

    static String factorial(int n) {
        BigInteger rs = BigInteger.ONE;
        while (n > 0) {
            rs = rs.multiply(BigInteger.valueOf(n));
            n--;
        }
        return rs.toString();
    }
}
