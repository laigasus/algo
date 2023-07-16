import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1639 {
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();

        int N = 2;

        int max = 0;
        while (N <= S.length()) {
            for (int i = 0; i <= S.length() - N; i++) {
                max = Math.max(max, calc(S.substring(i, i + N)));
            }
            N += 2;
        }
        System.out.println(max);
    }

    static int calc(String s) {
        int sum1 = 0, sum2 = 0;

        int halfLen = s.length() / 2;
        for (int i = 0; i < halfLen; i++) {
            sum1 += s.charAt(i);
            sum2 += s.charAt(i + halfLen);
        }

        return sum1 == sum2 ? s.length() : 0;
    }
}