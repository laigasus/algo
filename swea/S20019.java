import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class S20019 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = sc.next();

            int mid = (str.length() - 1) / 2;

            boolean a = isPalindrome(str);
            boolean b = isPalindrome(str.substring(0, str.length() % 2 == 0 ? mid + 1 : mid));
            boolean c = isPalindrome(str.substring(str.length() % 2 == 0 ? mid : mid + 1, str.length()));
            boolean result = a && b && c;

            sb.append(String.format("#%d %s\n", test_case, result ? "YES" : "NO"));
        }

        System.out.println(sb);
    }

    private static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();

        for (int i = 0; i < str.length(); i++) {
            if (reversed.charAt(i) != str.charAt(i)) {
                return false;
            }
        }

        return true;
    }

}