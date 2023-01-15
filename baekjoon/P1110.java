import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        br.close();
        int a, b;
        int start = Integer.parseInt(n);
        int cnt = 0;
        do {
            cnt++;
            if (n.length() < 2) {
                n = "0" + n;
            }
            a = n.charAt(0) - '0';
            b = n.charAt(1) - '0';
            n = b + "" + (a + b) % 10;
        } while (start != Integer.parseInt(n));
        System.out.println(cnt);
    }

}
