import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            calc(n);
        }
    }

    static void calc(int n) {
        StringBuilder sb = new StringBuilder();
        String s = Integer.toBinaryString(n);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                sb.append(s.length() - 1 - i).append(' ');
            }
        }
        System.out.println(sb);
    }
}