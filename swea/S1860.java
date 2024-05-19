
import java.io.FileInputStream;
import java.util.Scanner;

class S1860 {
    static final int MAX = 11_111;
    static int N, M, K;
    static int[] peoples;
    static int[] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();// 사람
            M = sc.nextInt();// M초마다
            K = sc.nextInt();// K개 붕어빵 만들수 있음

            board = new int[MAX + 1];

            for (int time = 1; time <= MAX; time++) {
                board[time] += board[time - 1];
                if (time % M == 0) {
                    board[time] += K;
                }
            }

            peoples = new int[N];// 사람들이 도착한 시각
            for (int i = 0; i < N; i++) {
                peoples[i] = sc.nextInt();
            }

            for (int people : peoples) {
                for (int time = people; time <= MAX; time++) {
                    board[time]--;
                }
            }

            boolean result = true;
            for (int time = 0; time <= MAX; time++) {
                if (board[time] < 0) {
                    result = false;
                    break;
                }
            }

            sb.append(String.format("#%d %s\n", test_case, result ? "Possible" : "Impossible"));
        }

        System.out.print(sb);
    }
}