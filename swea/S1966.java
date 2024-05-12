
import java.util.Arrays;
import java.util.Scanner;

class S1966 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + " ");
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            for (int e : arr) {
                sb.append(e).append(' ');
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}