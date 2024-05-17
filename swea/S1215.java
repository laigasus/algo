import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class S1215 {
    static StringBuilder sb = new StringBuilder();
    static final int SIZE = 8;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int depth = Integer.parseInt(br.readLine());
            board = new char[SIZE][SIZE];

            int cnt = 0;

            for (int i = 0; i < SIZE; i++) {
                String str = br.readLine();
                for (int j = 0; j < SIZE; j++) {
                    board[i][j] = str.charAt(j);
                }
            }

            cnt += countV(depth);
            cnt += countH(depth);

            sb.append(String.format("#%d %d\n", test_case, cnt));
        }

        System.out.println(sb);
    }

    private static int countH(int depth) {
        int cnt = 0;
        Deque<Character> deque;

        for (int y = 0; y < SIZE; y++) {
            deque = new ArrayDeque<>();
            for (int idx = 0; idx < depth; idx++) {
                deque.offerLast(board[y][idx]);
            }

            cnt += isPalindrome(new ArrayDeque<>(deque)) ? 1 : 0;

            for (int x = depth; x < SIZE; x++) {
                deque.pollFirst();
                deque.offerLast(board[y][x]);

                cnt += isPalindrome(new ArrayDeque<>(deque)) ? 1 : 0;
            }
        }

        return cnt;
    }

    private static int countV(int depth) {
        int cnt = 0;
        Deque<Character> deque;

        for (int x = 0; x < SIZE; x++) {
            deque = new ArrayDeque<>();
            for (int idx = 0; idx < depth; idx++) {
                deque.offerLast(board[idx][x]);
            }

            cnt += isPalindrome(new ArrayDeque<>(deque)) ? 1 : 0;

            for (int y = depth; y < SIZE; y++) {
                deque.pollFirst();
                deque.offerLast(board[y][x]);

                cnt += isPalindrome(new ArrayDeque<>(deque)) ? 1 : 0;
            }
        }

        return cnt;
    }

    private static boolean isPalindrome(Deque<Character> deque) {
        while (deque.size() > 1) {
            char front = deque.pollFirst();
            char rear = deque.pollLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }

}