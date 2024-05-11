import java.util.Scanner;

class S2068 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int max = 0;
            for (int i = 0; i < 10; i++) {
                max = Math.max(sc.nextInt(), max);
            }
            sb.append(String.format("#%d %d\n", test_case, max));
        }

        sc.close();
        System.out.println(sb);
    }
}