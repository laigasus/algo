import java.io.IOException;

public class P1747 {
    public static void main(String[] args) throws IOException {
        int N = readInt();

        while (!isPrime(N) || !isPalindrome(N)) {
            N++;
        }

        System.out.println(N);
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(int num) {
        int right = num;
        int left = 0;

        while (right > 0) {
            left = left * 10 + right % 10;
            right /= 10;
        }

        return num == left;
    }

    private static int readInt() throws IOException {
        int rs = 0;
        boolean isNegative = false;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        if (c == '-') {
            isNegative = true;
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return isNegative ? -rs : rs;
    }
}
