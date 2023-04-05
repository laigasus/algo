import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        do {
            sb.append("*".repeat(N)).append('\n');
        } while (N-- > 1);

        System.out.print(sb);
    }
}
