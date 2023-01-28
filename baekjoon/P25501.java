import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P25501 {
    static int callRe;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            callRe = 0;
            sb.append(isPalindrome(br.readLine())).append(" ").append(callRe).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    static int recursion(String s, int l, int r) {
        callRe++;
        if (l >= r)
            return 1;
        else if (s.charAt(l) != s.charAt(r))
            return 0;
        else
            return recursion(s, l + 1, r - 1);
    }

    static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }
}
