import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P28138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long R = Long.parseLong(st.nextToken());

        System.out.println(calc(N, R));
    }

    public static long calc(long N, long R) {
        long sum = 0;
        long P = N - R;

        for (long i = 1; i <= (long) Math.sqrt(P); i++) {
            if (P % i == 0) {
                if (i > R) {
                    sum += i;
                }
                if (i * i != P && P / i > R) {
                    sum += P / i;
                }

            }
        }
        return sum;
    }
}