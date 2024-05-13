import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class S2805 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            int[][] board = new int[N][N];

            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < N; j++) {
                    board[i][j] = str.charAt(j) - '0';
                }
            }

            int sum = 0;

            int left = N / 2, right = N / 2;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (left <= j && j <= right) {
                        sum += board[i][j];
                    }
                }
                switch (Integer.signum(i - N / 2)) {
                    case -1:
                        left--;
                        right++;
                        break;
                    case 0:
                    case 1:
                        left++;
                        right--;
                        break;
                }
            }

            sb.append(String.format("#%d %d\n", test_case, sum));
        }

        System.out.println(sb);
    }
}