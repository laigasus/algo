import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String X = br.readLine();
        int cnt = 0;
        while (X.length() > 1) {
            int tmp = 0;
            for (int i = 0; i < X.length(); i++) {
                tmp += (X.charAt(i) - '0');
            }
            X = Integer.toString(tmp);
            cnt++;
        }

        System.out.println(cnt);
        System.out.println(Integer.parseInt(X.toString()) % 3 == 0 ? "YES" : "NO");
    }
}