
import java.util.Scanner;

class S1859 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int length = sc.nextInt();
            int[] arr = new int[length];

            for (int i = 0; i < length; i++) {
                arr[i] = sc.nextInt();
            }

            long result = 0;
            int max = arr[length - 1];

            for (int i = length - 2; i >= 0; i--) {
                if (max <= arr[i]) {
                    max = arr[i];
                } else {
                    result += (max - arr[i]);
                }
            }

            sb.append("#" + test_case + " " + result + "\n");
        }
        System.out.println(sb);
    }
}