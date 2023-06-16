import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 3;

        while (T-- > 0) {
            BigInteger rs = new BigInteger("0");
            int N = Integer.parseInt(br.readLine());

            while (N-- > 0) {
                rs = rs.add(new BigInteger(br.readLine()));
            }

            switch (rs.compareTo(BigInteger.ZERO)) {
                case -1:
                    sb.append("-");
                    break;
                case 1:
                    sb.append("+");
                    break;
                default:
                    sb.append(0);
                    break;
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}