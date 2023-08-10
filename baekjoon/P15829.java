import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15829 {
    public static void main(String[] args) throws IOException {
        final int M = 1_234_567_891, PRIME_NUM = 31;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long sum = 0, pow = 1;

        for (int i = 0; i < L; i++) {
            sum += (str.charAt(i) - 'a' + 1) * pow % M;
            pow = pow * PRIME_NUM % M;
        }
        System.out.println(sum % M);
    }
}