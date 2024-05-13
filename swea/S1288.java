import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class S1288 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            long N = sc.nextInt();

            long result = count(N);

            sb.append(String.format("#%d %d\n", test_case, result));
        }

        System.out.println(sb);
    }

    private static long count(long start) {
        long now = start;
        Set<Integer> set = new HashSet<>();
        while (now < Long.MAX_VALUE) {
            String str = String.valueOf(now);

            for (char c : str.toCharArray()) {
                int num = c - '0';
                set.add(num);
            }

            if (set.size() >= 10) {
                break;
            }
            now += start;
        }

        return now;
    }
}