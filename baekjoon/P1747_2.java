import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1747_2 {
    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        do {
            if (isPrime(n) && isPalindrome(n)) {
                break;
            }
        } while (n++ < MAX);

        System.out.println(n);
    }

    private static boolean isPalindrome(int n) {
        String tmp = Integer.toString(n);

        for (int i = 0; i < tmp.length() / 2; i++) {
            if (tmp.charAt(i) != tmp.charAt(tmp.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int num = 2; num <= Math.sqrt(n); num++) {
            if (n % num == 0) {
                return false;
            }
        }

        return true;
    }
}