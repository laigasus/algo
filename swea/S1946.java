import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

class S1946 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + "\n");
            ArrayDeque<Character> deque = new ArrayDeque<>();

            int N = sc.nextInt();

            while (N-- > 0) {
                char alphabet = sc.next().charAt(0);

                int repeat = sc.nextInt();

                while (repeat-- > 0) {
                    deque.offerLast(alphabet);
                }
            }

            sb.append(insert(deque));
        }

        System.out.println(sb);
    }

    private static StringBuilder insert(ArrayDeque<Character> deque) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
            cnt++;
            if (cnt == 10) {
                sb.append('\n');
                cnt = 0;
            }
        }

        if (cnt != 0) {
            sb.append('\n');
        }

        return sb;
    }

}