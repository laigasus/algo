import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class S20728 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[] pockets = new int[N];

            for (int i = 0; i < N; i++) {
                pockets[i] = sc.nextInt();
            }

            Arrays.sort(pockets);

            int min = Integer.MAX_VALUE;
            for (int left = 0; left <= N - K; left++) {
                int right = left + K - 1;

                int diff = pockets[right] - pockets[left];
                min = Math.min(min, diff);
            }

            sb.append(String.format("#%d %d\n", test_case, min));
        }

        System.out.println(sb);
    }

}