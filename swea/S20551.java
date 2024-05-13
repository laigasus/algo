import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class S20551 {
    static StringBuilder sb = new StringBuilder();
    static final int SIZE = 3;
    static int[] boxes;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            boxes = new int[SIZE + 2];
            boxes[boxes.length - 1] = Integer.MAX_VALUE;

            for (int i = 1; i <= SIZE; i++) {
                boxes[i] = sc.nextInt();
            }

            int cnt = 0;
            loop: do {
                cnt += calibrate();
                if (isUnder1()) {
                    cnt = -1;
                    break loop;
                }
            } while (!isValid());

            sb.append(String.format("#%d %d\n", test_case, cnt));
        }

        System.out.println(sb);
    }

    private static boolean isUnder1() {
        for (int i = 1; i <= SIZE; i++) {
            if (boxes[i] < 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValid() {
        for (int i = 1; i <= SIZE; i++) {
            int after = boxes[i + 1];
            int now = boxes[i];
            int before = boxes[i - 1];

            if (before < now && now < after) {
                continue;
            }
            return false;
        }

        return true;
    }

    private static int calibrate() {
        int cnt = 0;
        for (int i = 1; i <= SIZE; i++) {
            int after = boxes[i + 1];
            int now = boxes[i];
            if (now >= after) {
                now -= 1;
                cnt++;
                boxes[i] = now;
                i--;
            }
        }
        return cnt;
    }

}