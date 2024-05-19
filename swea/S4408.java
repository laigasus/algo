
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class S4408 {

    static final int SIZE = 400;
    static int N;
    static int[] rooms;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();

            rooms = new int[SIZE + 1];

            for (int i = 0; i < N; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                end = end % 2 != 0 ? Math.min(end + 1, SIZE) : end;

                if (start > end) { // swap
                    int tmp = start;
                    start = end;
                    end = tmp;
                } else if (start == end) { // 시작과 끝이 동일하면 계산 제외
                    continue;
                }

                for (int j = start; j <= end; j++) {
                    rooms[j] += 1;
                }
            }

            int max = Arrays.stream(rooms).max().getAsInt();
            sb.append(String.format("#%d %d\n", test_case, max));
        }

        System.out.print(sb);
    }
}