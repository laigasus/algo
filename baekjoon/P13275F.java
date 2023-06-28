import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P13275F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int max = 1;
        for (int left = 0; left < S.length(); left++) {
            for (int right = left; right < S.length(); right++) {
                if (right - left < max) {
                    continue;
                }
                if (isPalindrome(S.substring(left, right + 1))) {
                    max = Integer.max(max, right - left + 1);
                }
            }
        }

        System.out.println(max);
    }

    static boolean isPalindrome(String s) {
        int len = s.length();
        for (int idx = 0; idx < len / 2; idx++) {
            if (s.charAt(idx) != s.charAt(len - 1 - idx)) {
                return false;
            }
        }

        return true;
    }
}