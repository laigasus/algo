import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class S1220 {
    static StringBuilder sb = new StringBuilder();
    static StringBuilder[] lines;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = 10;
        // N극 1, S극 2
        for (int test_case = 1; test_case <= T; test_case++) {
            int size = sc.nextInt();

            int cnt = 0;
            lines = new StringBuilder[size];
            for (int i = 0; i < size; i++) {
                lines[i] = new StringBuilder();
            }

            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {
                    int num = sc.nextInt();
                    lines[x].append(num == 1 ? "N" : (num == 2 ? "S" : ""));
                }
            }

            // 교착 상태가 벌어진 경우 세기 (NS 인 것만)
            for (int x = 0; x < size; x++) {
                cnt += countDeadLock(lines[x]);
            }

            sb.append(String.format("#%d %d\n", test_case, cnt));
        }

        System.out.println(sb);
    }

    private static int countDeadLock(StringBuilder line) {
        int cnt = 0;

        for (int left = 0; left < line.length() - 1; left++) {
            int right = left + 1;

            if (line.charAt(left) == 'N' && line.charAt(right) == 'S') {
                cnt++;
            }
        }

        return cnt;
    }

}