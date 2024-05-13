import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class S1244 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            max = 0;
            String str = sc.next();
            int swapLimit = sc.nextInt();

            if (swapLimit > str.length()) {
                swapLimit = str.length();
            }

            swap(str, swapLimit);

            sb.append(String.format("#%d %d\n", test_case, max));
        }

        sc.close();

        System.out.println(sb);
    }

    static int max;

    private static void swap(String str, int changes) {
        if (changes <= 0) {
            max = Math.max(max, Integer.parseInt(str));
            return;
        }

        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < sb.length() - 1; i++) {
            for (int j = i + 1; j < sb.length(); j++) {
                char a = sb.charAt(i);
                char b = sb.charAt(j);

                sb.replace(i, i + 1, b + "");
                sb.replace(j, j + 1, a + "");

                String next = sb.toString();
                swap(next, changes - 1);

                sb.replace(i, i + 1, a + "");
                sb.replace(j, j + 1, b + "");
            }
        }
    }
}