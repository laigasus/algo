import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (char c : br.readLine().toCharArray()) {
            sb.append((char) ((int) c ^ 32));
        }
        System.out.println(sb);
    }
}
