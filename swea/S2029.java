
import java.util.Scanner;

class S2029 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sb.append(String.format("#%d %d %d\n", test_case, a / b, a % b));
        }

        System.out.println(sb);
    }
}