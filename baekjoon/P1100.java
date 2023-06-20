import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 8, cnt = 0;

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            for (int j = i % 2; j < T; j += 2) {
                if (s.charAt(j) == 'F') {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}