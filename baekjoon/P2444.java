import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int mid = (2 * N - 1) / 2;
        int stars = 1;
        int blanks = N - 1;
        for (int i = 0; i < 2 * N - 1; i++) {
            sb.append(" ".repeat(blanks)).append("*".repeat(stars)).append("\n");
            if (i >= mid) {
                blanks += 1;
                stars -= 2;
            } else {
                blanks -= 1;
                stars += 2;
            }
        }

        System.out.print(sb);
    }
}