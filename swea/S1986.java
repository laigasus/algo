
import java.util.Scanner;

class S1986 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        final int MAX = 10;
        int[] arr = new int[MAX + 1];
        for (int num = 1; num <= MAX; num++) {
            arr[num] = arr[num - 1] + (num % 2 == 0 ? -num : num);
        }

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            sb.append(String.format("#%d %d\n", test_case, arr[N]));
        }

        System.out.println(sb);
    }
}