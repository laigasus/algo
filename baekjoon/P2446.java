import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            sb.append(" ".repeat(i) + "*".repeat(N * 2 - 2 * i - 1)).append('\n');
        }
        for (int i = 1; i <= N; i++) {
            sb.append(" ".repeat(N - i) + "*".repeat(2 * i - 1)).append('\n');
        }

        System.out.print(sb);
    }
}