import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1, range = 2;
        int n = Integer.parseInt(br.readLine());
        br.close();

        if (n == 1) {
            System.out.println(1);
        }

        else {
            while (range <= n) {
                range = range + (6 * cnt);
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
