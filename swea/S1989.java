
import java.util.Scanner;

class S1989 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            String str = sc.next();
            int result = isPalindrome(str);
            sb.append("#" + test_case + " " + result).append("\n");
        }

        System.out.println(sb);
    }

    private static int isPalindrome(String str) {
        int mid = str.length() / 2 + str.length() % 2;
        for (int i = 0; i < mid; i++) {
            char left = str.charAt(i);
            char right = str.charAt(str.length() - 1 - i);
            if (left != right) {
                return 0;
            }
        }

        return 1;
    }
}