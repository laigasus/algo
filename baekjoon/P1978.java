import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        List<Integer> isDecimalList = new ArrayList<>(len);
        while (st.hasMoreTokens()) {
            isDecimalList.add(Integer.parseInt(st.nextToken()));
        }
        long cnt = isDecimalList.stream().filter(i -> BigInteger.valueOf(i).isProbablePrime(10)).count();
        System.out.println(cnt);
    }
}
