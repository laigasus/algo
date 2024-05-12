
import java.util.Scanner;

class S1970 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        final int[] coins = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
        int[] charges;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            charges = new int[coins.length];
            for (int i = 0; i < coins.length; i++) {
                charges[i] = N / coins[i];
                N %= coins[i];
            }

            sb.append("#" + test_case + "\n");
            for (int charge : charges) {
                sb.append(charge).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}