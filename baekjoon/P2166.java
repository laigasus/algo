import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//신발끈 공식 문제
public class P2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] x = new long[N + 1], y = new long[N + 1];
        long sumA = 0, sumB = 0;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        x[N] = x[0];
        y[N] = y[0];

        for (int i = 0; i < N; i++) {
            sumA += x[i] * y[i + 1];
            sumB += x[i + 1] * y[i];
        }

        System.out.printf("%.1f\n", Math.abs(sumB - sumA) / 2.0);
    }
}