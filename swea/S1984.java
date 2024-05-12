
import java.util.Scanner;

class S1984 {
    public static void main(String args[]) throws Exception {
        final int LEN = 10;
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int sum = 0;
            int max = 0, min = 10000;

            for (int i = 0; i < LEN; i++) {
                int num = sc.nextInt();
                max = Math.max(max, num);
                min = Math.min(min, num);
                sum += num;
            }
            sum -= (max + min);

            sb.append(String.format("#%d %d\n", test_case, Math.round(sum * 1.0 / 8)));
        }

        System.out.println(sb);
    }
}