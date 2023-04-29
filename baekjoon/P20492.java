import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P20492 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        sb.append((int) (n * 0.78));
        sb.append(" ");
        sb.append((int) (n * 0.8 + (n * 0.2 * 0.78)));
        System.out.println(sb);
    }
}
