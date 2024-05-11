
import java.util.Scanner;

class S1926 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int num = 1; num <= T; num++) {
            int claps = countClap(num);
            if (claps > 0) {
                while (claps-- > 0) {
                    sb.append('-');
                }
            } else {
                sb.append(num);
            }
            sb.append(' ');
        }

        System.out.println(sb);
    }

    private static int countClap(int num) {
        final char[] check = { '3', '6', '9' };

        int cnt = 0;
        String s = String.valueOf(num);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            for (char tmp : check) {
                if (c == tmp) {
                    cnt++;
                    break;
                }
            }
        }

        return cnt;
    }
}