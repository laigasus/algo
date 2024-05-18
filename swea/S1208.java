import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class S1208 {
    static final int SIZE = 100;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int dump = sc.nextInt();

            int left = SIZE, right = 0;
            int board[] = new int[SIZE + 1];

            for (int repeat = 0; repeat < SIZE; repeat++) {
                int num = sc.nextInt();

                board[num]++;

                left = Math.min(left, num);
                right = Math.max(right, num);
            }

            int result = 0;
            while (dump-- > 0 && left < right) {
                board[left]--;
                board[left + 1]++;

                board[right]--;
                board[right - 1]++;

                if (board[left] == 0) {
                    left++;
                }

                if (board[right] == 0) {
                    right--;
                }
            }

            result = right - left;

            sb.append(String.format("#%d %d\n", test_case, result));
        }

        sc.close();

        System.out.println(sb);
    }

}