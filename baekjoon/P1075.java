import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        N = N / 100 * 100;

        while (true) {
            if (N % F == 0) {
                break;
            }
            N++;
        }
        int rs = N % 100;
        if (rs < 10) {
            sb.append('0');
        }
        sb.append(rs);
        System.out.println(sb);
    }
}