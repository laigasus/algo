import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            sb.append("*".repeat(i)).append(" ".repeat(2 * (N - i))).append("*".repeat(i)).append('\n');
        }
        
        StringBuilder sbReverse = new StringBuilder(sb).reverse();
        sb.append("*".repeat(2 * N));
        sb.append(sbReverse);

        System.out.print(sb);
    }
}
