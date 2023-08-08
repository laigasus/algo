import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1259 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while (!(s = br.readLine()).equals("0")) {
            sb.append(isPalindrome(s) ? "yes" : "no").append('\n');
        }

        System.out.print(sb);
    }

    static boolean isPalindrome(String s) {
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}